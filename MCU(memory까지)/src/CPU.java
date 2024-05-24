import Register.IR;
import Register.MAR;
import Register.MBR;
import Register.Register;
import format.SInstructionSet;

public class CPU {
    public enum Estate {
        eSTOPPED,
        eRUNNING
    }

    private Memory memory;

    public void associate(Memory memory) {
        this.memory = memory;
    }

    private Estate estate;
    private IR ir;
    public MBR mbr;
    public MAR mar;
    public Register pc, ac, cs, ds, ss, hs, sp;

    public CPU() {
        ir = new IR();
        mbr = new MBR();
        mar = new MAR();
        pc = new Register();
        ac = new Register();
        cs = new Register();
        ds = new Register();
        ss = new Register();
        hs = new Register();
        sp = new Register();
    }
}
//
//    public void start() {
//        this.estate = Estate.eRUNNING;
//        pc.setValue(0);
//    }
//
//    public void run() {
////        System.out.println("\n<count 10 program running>");
//        while(this.estate == Estate.eRUNNING) {
////            System.out.println("PC: " + pc.getValue());
//            this.fetch();
//            this.decode();
//            this.execute();
//        }
//    }
//
//    private void fetch() {
//        mar.setValue(cs.getValue() + pc.getValue());
//        memory.load();
//        ir.setInstructionSet(mbr.getInstructionSet());
//    }
//
//    private void decode() {
//        SInstructionSet.InstructionSet operator = null;
//        SAddressingMode.AddressingMode adCode = null;
//
//        for(SInstructionSet.InstructionSet instruction : SInstructionSet.InstructionSet.values()) {
//            if (instruction.getOpCode().equals(ir.getOperator())) {
//                operator = instruction;
//            }
//        }
//        for(SAddressingMode.AddressingMode addressingMode : SAddressingMode.AddressingMode.values()) {
//            if (addressingMode.getAddressingMode().equals(ir.getAddressingMode())) {
//                adCode = addressingMode;
//            }
//        }
//        operation = new SOperation(operator, adCode);
//    }
//
//    private void execute() {
//        pc.setValue(pc.getValue() + 1);
//        switch (operation.getOperator()) {
//            case MOV:
//                this.mov();
//                break;
//            case ADD:
//                this.add();
//                break;
//            case SUB:
//                this.sub();
//                break;
//            case MUL:
//                this.mul();
//                break;
//            case DIV:
//                this.div();
//                break;
//            case JMP:
//                this.jmp();
//                break;
//            case GTJ:
//                this.gtj();
//                break;
//            case GEJ:
//                this.gej();
//                break;
//            case HALT:
//                this.halt();
//                break;
//            case LDI:
//                this.memory.ldi();
//                break;
//            case LDA:
//                this.memory.lda();
//                break;
//            case STO:
//                this.memory.store();
//                break;
//            default:
//                 break;
//        }
//    }
//
//    public void mov() {
//        SRegisterSet.registerSet registerSet1 = null, registerSet2 = null;
//        Register register1 = null, register2 = null;
//
//        for(SRegisterSet.registerSet registerSet : SRegisterSet.registerSet.values()) {
//            if (registerSet.getRCode().equals(ir.getOperand1())) {
//                registerSet1 = registerSet;
//            }
//        }
//
//        switch (registerSet1){
//            case MAR:
//                register1 = mar;
//                break;
//            case MBR:
//                register1 = mbr;
//                break;
//            case AC1:
//                register1 = ac1;
//                break;
//            case AC2:
//                register1 = ac2;
//                break;
//            default:
//                break;
//        }
//
//        switch(operation.getAddressingMode()) {
//            case Register:
//                for(SRegisterSet.registerSet registerSet : SRegisterSet.registerSet.values()) {
//                    if(registerSet.getRCode().equals(ir.getOperand2())) {
//                        registerSet2 = registerSet;
//                    }
//                }
//
//                switch (registerSet2){
//                    case MAR:
//                        register2 = mar;
//                        break;
//                    case MBR:
//                        register2 = mbr;
//                        break;
//                    case AC1:
//                        register2 = ac1;
//                        break;
//                    case AC2:
//                        register2 = ac2;
//                        break;
//                    default:
//                        break;
//                }
//                register1.setValue(register2.getValue());
//                break;
//            case Direct:
//                int constant = Integer.parseInt(ir.getOperand2(), 2);
//                register1.setValue(constant);
//                break;
//            case Indirect:
//                int address = Integer.parseInt(ir.getOperand2(), 2) + ds.getValue();
//                mar.setAddress(address);
//                break;
//            default:
//                break;
//        }
//    }
//
//    public void add() {
//        ac1.setValue(ac1.getValue() + ac2.getValue());
//    }
//    public void sub() {
//        ac1.setValue(ac1.getValue() - ac2.getValue());
//    }
//    private void mul() {
//        ac1.setValue(ac1.getValue() * ac2.getValue());
//    }
//    private void div() {
//        ac1.setValue(ac1.getValue() / ac2.getValue());
//    }
//
//    private void gtj() {
//        if(ac1.getValue() >= 0){
//            pc.setValue(Integer.parseInt(ir.getOperand1(),2) - 1);
//        }
//    }
//
//    private void gej() {
//    }
//
//    private void jmp() {
//        pc.setValue(Integer.parseInt(ir.getOperand1(),2) - 1);
//    }
//
//    public void halt() {
//        this.estate = Estate.eSTOPPED;
//    }
//}
