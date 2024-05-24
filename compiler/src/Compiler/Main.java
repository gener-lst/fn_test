package Compiler;

public class Main {
    public static void main(String[] args) {
        SCompiler compiler = new SCompiler();
        compiler.initialize();
        compiler.run();
        compiler.finalize();
    }
}