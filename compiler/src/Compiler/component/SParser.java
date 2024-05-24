package Compiler.component;

import Compiler.parseTree.SProgram;
import Compiler.parseTree.SStatement;
import format.SSymbolEntity;
import format.SSymbolTable;

import java.util.Vector;

public class SParser {
    private SSymbolTable symbolTable;
    private Vector<SStatement> parseTree;
    public void parse(SLex lex) {
        this.symbolTable = new SSymbolTable();
        this.parseTree = new Vector<>();
        SProgram program = new SProgram(symbolTable, parseTree);
        program.parse(lex);
//        generateSymbolTable(symbolTable);
//        generateCode(parseTree);
    }

    public void generateSymbolTable(Vector<SSymbolEntity> declarations) {
        System.out.println("\n<SymbolTable>");
        for (SSymbolEntity symbol : declarations) {
            System.out.println(symbol.getSymbolName() + " " + symbol.getType() + " " + symbol.getValue());
        }
    }
    // 생성된 SymbolTable을 print하는 함수
    public void generateCode(Vector<SStatement> statements) {
        System.out.println("\n<parseTree>");
        for (SStatement statement : statements) {
            if(statement.getOperand() == null) {
                System.out.println(statement.getOperator());
            } else {
                System.out.println(statement.getOperator() + " " + statement.getOperand());
            }
        }
    }
    // 생성된 ParseTree을 print하는 함수
    public SSymbolTable tossSymbolTable() {
        return this.symbolTable;
    }
    public Vector<SStatement> tossParseTree() {
        return this.parseTree;
    }
}
