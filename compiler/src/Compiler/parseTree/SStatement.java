package Compiler.parseTree;

import Compiler.component.SLex;

public class SStatement implements INode {
    private String operator;
    private String operand;

    public SStatement(String operator) {
        this.operator = operator;
    }

    public SStatement(String operator, String operand) {
        this.operator = operator;
        this.operand = operand;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperand() {
        return operand;
    }

    public void setOperand(String operand) {
        this.operand = operand;
    }

    @Override
    public String parse(SLex lex) {
        return operator;
    }
}