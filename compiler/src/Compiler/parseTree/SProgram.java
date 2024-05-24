package Compiler.parseTree;

import Compiler.component.SLex;
import format.SSymbolTable;

import java.util.Vector;

public class SProgram implements INode {
    private SSymbolTable symbolTable;
    private Vector<SStatement> parseTree;
    private SDataSegment dataSegment;
    private SCodeSegment codeSegment;

    public SProgram(SSymbolTable symbolTable, Vector<SStatement> parseTree) {
        this.symbolTable = symbolTable;
        this.parseTree = parseTree;
        this.dataSegment = new SDataSegment(symbolTable);
        this.codeSegment = new SCodeSegment(symbolTable, parseTree);
    }

    @Override
    public String parse(SLex lex) {
        String token = lex.getToken();
        if (token.compareTo(".data") == 0) {
            token = this.dataSegment.parse(lex);
        }
        if (token.compareTo(".code") == 0) {
            token = this.codeSegment.parse(lex);
        }
        return null;
    }
}
