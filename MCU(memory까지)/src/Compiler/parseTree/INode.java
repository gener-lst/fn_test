package Compiler.parseTree;

import Compiler.component.SLex;

public interface INode {
    public abstract String parse(SLex lex);
}