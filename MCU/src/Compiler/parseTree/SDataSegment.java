package Compiler.parseTree;

import Compiler.component.SLex;
import format.SSymbolEntity;
import format.SSymbolTable;

public class SDataSegment implements INode {
    private SSymbolTable declarations;

    public SDataSegment(SSymbolTable symbolTable) {
        this.declarations = symbolTable;
    }

    @Override
    public String parse(SLex lex) {
        String token = lex.getToken();
        while(token.compareTo(".code") != 0) {
            SSymbolEntity declaration = new SSymbolEntity();
            declaration.setSymbolName(token);
            declaration.setType(SSymbolEntity.type.Constant);
            declaration.setAddress(lex.getToken());
            declaration.setValue(lex.getToken());
            this.declarations.add(declaration);
            token = lex.getToken();
        }
        return token;
    }
}