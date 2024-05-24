package Compiler.component;

import Compiler.parseTree.SStatement;
import format.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class SCodeGenerator {
    private SSymbolTable symbolTable;
    private Vector<SStatement> parseTree;
    private Vector<String> objectCode;
    private int CS, DS, SS, HS, SP;
    private Vector<Integer> SL;

    public void run(SParser parser) {
        symbolTable = parser.tossSymbolTable();
        parseTree = parser.tossParseTree();
        this.objectCode = new Vector<>();
        setHeader();
        translateCode();
        generateCode(objectCode);
    }

    public void setHeader() {
        String cs, ds, ss, hs;
        CS = 0;
        DS = parseTree.size();
        SS = DS + 64;
        HS = SS + 64;
        int count = 0;

        cs = String.format("%2s", Integer.toHexString(parseTree.size())).replace(" ","0");
        for(SSymbolEntity symbol : symbolTable) {
            if(symbol.getType() == SSymbolEntity.type.Constant || symbol.getType() == SSymbolEntity.type.Variable) {
                count += 1;
            }
        }
        ds = String.format("%2s", Integer.toHexString(count)).replace(" ","0");
        ss = String.format("%2s", Integer.toHexString(64)).replace(" ","0");
        hs = String.format("%2s", Integer.toHexString(64)).replace(" ","0");
        objectCode.add(cs);
        objectCode.add(ds);
        objectCode.add(ss);
        objectCode.add(hs);
        objectCode.add("");
    }

    public void translateCode() {
        String data, operator, operand, instructionSet;
        String token;

        this.SL = new Vector<>();

        for (SStatement statement : parseTree) {
            operand = "00";

            token = statement.getOperator();
            operator = checkInstructionSet(token);
            if (token.equals("push")) {
                SL.add(Integer.parseInt(statement.getOperand())/4);
                SP = SP + SL.lastElement();
            }
            if (token.equals("pop")) {
                SP = SP - SL.lastElement();
                SL.remove(SL.size() - 1);
            }
            if (statement.getOperand() != null) {
                token = statement.getOperand();
                operand = translateOperand(token);
            }
            instructionSet = operator + operand;
            objectCode.add(instructionSet);
        }
        objectCode.add("");

        for(SSymbolEntity symbol : symbolTable) {
            if (symbol.getType() == SSymbolEntity.type.Constant || symbol.getType() == SSymbolEntity.type.Variable) {
                String hexString = "";
                data = symbol.getValue();
                for (char c : data.toCharArray()) {
                    String hex = Integer.toHexString(c);
                    hexString += hex;
                }
                objectCode.add(hexString);
            }
        }
    }

    public void generateCode(Vector<String> objectCode) {
        for(String symbol : objectCode) {
            System.out.println(symbol);
        }

        try {
            FileWriter writer = new FileWriter("source/objectCode");
            for(String line : objectCode) {
                writer.write(line);
                writer.write(System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String checkInstructionSet(String token) {
        for (SInstructionSet.InstructionSet instruction : SInstructionSet.InstructionSet.values()) {
            if(instruction.getInstructionName().equals(token)) {
                return instruction.getOpCode();
            }
        }
        return null;
    }

    public String translateOperand(String token) {
        String operand = null;
        if(token.startsWith("[")){
            token = token.replace("[", "").replace("]", "");

            if(token.contains("+")) {
                String[] address = token.split("\\+");
                switch (address[0]) {
                    case "DS":
                        operand = String.format("%2s", Integer.toHexString(DS + Integer.parseInt(address[1])/4)).replace(" ","0");
                        break;
                    case "HS":
                        operand = String.format("%2s", Integer.toHexString(HS + Integer.parseInt(address[1])/4)).replace(" ","0");
                        break;
                }
            } else if (token.contains("-")) {
                String[] address = token.split("-");
                operand = String.format("%2s", Integer.toHexString(SP - Integer.parseInt(address[1])/4)).replace(" ","0");
            } else {
                switch (token) {
                    case "DS": operand = String.format("%2s", Integer.toHexString(DS)).replace(" ","0"); break;
                    case "SP": operand = String.format("%2s", Integer.toHexString(SP)).replace(" ","0"); break;
                    case "HS": operand = String.format("%2s", Integer.toHexString(HS)).replace(" ","0"); break;
                }
            }
        } else if(token.matches("^[a-z][a-zA-Z0-9]*$")) {
            for (SSymbolEntity symbol : symbolTable) {
                if (symbol.getSymbolName().equals(token) && symbol.getValue() != null) {
                    operand = String.format("%2s", Integer.toHexString(Integer.parseInt(symbol.getValue()))).replace(" ","0");
                }
            }
        } else if(token.matches("^[0-9]*$")) {
            operand = String.format("%2s", Integer.toHexString(Integer.parseInt(token))).replace(" ","0");
        }
        return operand;
    }
}
