package Compiler.parseTree;

import Compiler.component.SLex;
import format.SSymbolEntity;
import format.SSymbolTable;

import java.util.Vector;

public class SCodeSegment implements INode {
    private SSymbolTable symbolTable;
    private Vector<SStatement> parseTree;
    public SCodeSegment(SSymbolTable symbolTable, Vector<SStatement> parseTree) {
        this.parseTree = parseTree;
        this.symbolTable = symbolTable;
    }

    @Override
    public String parse(SLex lex) {
        String[] tokens = lex.getTokens();
        String operator = tokens[0];
        int headerSize = symbolTable.size();
        while (operator.compareTo(".end") != 0) {
            if (operator.startsWith("//") || (operator.length() == 0)) {
                // skip
            } else if (operator.contains(":")) {
                SSymbolEntity entity = new SSymbolEntity();
                entity.setSymbolName(operator.replace(":", ""));
                entity.setType(SSymbolEntity.type.Label);
                entity.setValue(Integer.toString(this.parseTree.size() + 1));
                this.symbolTable.insertElementAt(entity, headerSize);
                headerSize += 1;
            } else {
                // parse tree
                SStatement statement = null;
                createSymbolTable(tokens);
                switch (tokens.length) {
                    case 1:
                        statement = new SStatement(tokens[0]);
                        break;
                    case 2:
                        statement = new SStatement(tokens[0], tokens[1]);
                        break;
                    default:
                        break;
                }
                this.parseTree.add(statement);
            }
            tokens = lex.getTokens();
            operator = tokens[0];
        }
        return operator;
    }

    public void createSymbolTable(String[] tokens) {
        SSymbolEntity entity = new SSymbolEntity();

        if(tokens.length == 2) {
            if(tokens[1].matches("^[a-z][a-zA-Z0-9]*$")) {
                entity.setSymbolName(tokens[1]);
                entity.setType(SSymbolEntity.type.Label);
                this.symbolTable.add(entity);
            }
        }
    }
}
