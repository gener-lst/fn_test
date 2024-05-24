package format;

public class SInstructionSet {
    public enum InstructionSet {
        ADDA("adda", "00"),
        ADDC("addc", "01"),
        SUBA("suba", "02"),
        SUBC("subc", "03"),
        MULA("mula", "04"),
        MULC("mulc", "05"),
        DIVA("diva", "06"),
        DIVC("divc", "07"),
        JMP("jmp", "08"),
        BZJ("bzj", "09"),
        EQJ("eqj", "0a"),
        LDA("lda", "0b"),
        LDC("ldc", "0c"),
        STO("sto", "0d"),
        STOA("stoa", "0e"),
        PUSH("push", "0f"),
        POP("pop", "10"),
        NEW("new", "11"),
        NEWA("newa", "12"),
        IN("in", "13"),
        OUT("out", "14"),
        HALT("halt", "15"),
        LDS("lds", "16");

        private String instructionName;
        private String opCode;

        private InstructionSet(String instructionName, String opCode) {
            this.instructionName = instructionName;
            this.opCode = opCode;
        }

        public String getInstructionName() {
            return instructionName;
        }

        public String getOpCode() {
            return opCode;
        }
    }
}
