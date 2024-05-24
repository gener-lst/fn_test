package Compiler;

import Compiler.component.SCodeGenerator;
import Compiler.component.SLex;
import Compiler.component.SParser;

public class SCompiler {
    private SParser parser;
    private SLex lex;
    private SCodeGenerator codeGenerator;

    public SCompiler() {}

    public void initialize() {
        lex = new SLex();
        lex.initialize("source/AssemblyCode");
        parser = new SParser();
        codeGenerator = new SCodeGenerator();
    }

    public void finalize() {
        lex.finalize();
    }

    public void run() {
        parser.parse(this.lex);
        codeGenerator.run(this.parser);
    }
}
