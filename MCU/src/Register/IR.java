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

    public String getOperator() {
        String eOperator;
        eOperator = instructionSet.substring(0, 2);
        return eOperator;
    }

    public String getOperand() {
        String eOperand1;
        eOperand1 = instructionSet.substring(2, 4);
        return eOperand1;
    }

}
