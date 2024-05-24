import Compiler.SCompiler;

public class SMain {
    public static void main(String [] args) {
        CPU cpu = new CPU();
        Memory memory = new Memory();
        SCompiler compiler = new SCompiler();
        SKeyboard keyboard = new SKeyboard();
        cpu.associate(memory);
        memory.associate(cpu.mar, cpu.mbr, cpu.cs, cpu.ds, cpu.ss, cpu.hs, keyboard);
        compiler.initialize();
        compiler.run();
        compiler.finalize();
        memory.read();
//        cpu.start();
//        cpu.run();
    }
}
