package Register;

public class IR extends Register {
    private String instructionSet;

    public String getInstructionSet() {
        return instructionSet;
    }

    public IR() {
        super();
    }

    public void setInstructionSet(String instructionSet) {
        this.instructionSet = instructionSet;
    }

    public String getAddressingMode() {
        String eAddressingMode;
        eAddressingMode = instructionSet.substring(0, 2);
        return eAddressingMode;
    }

    public String getOperator() {
        String eOperator;
        eOperator = instructionSet.substring(2, 8);
        return eOperator;
    }

    public String getOperand1() {
        String eOperand1;
        eOperand1 = instructionSet.substring(8, 20);
        return eOperand1;
    }

    public String getOperand2() {
        String eOperand2;
        eOperand2 = instructionSet.substring(20, 32);
        return eOperand2;
    }
}
