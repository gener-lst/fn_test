import Register.IR;
import Register.MAR;
import Register.MBR;
import Register.Register;
import format.SInstructionSet;

import java.util.Scanner;

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
    SInstructionSet.InstructionSet operator;
    private IR ir;
    public MBR mbr;
    public MAR mar;
    public Register pc, ac, cs, ds, ss, hs, sp, sl;

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
        sl = new Register();
    }
}
//
//
//    public void start() {
//        this.estate = Estate.eRUNNING;
//        pc.setValue(0);
//    }
//
//    public void run() {
//        System.out.println("\n<program running>");
//        while(this.estate == Estate.eRUNNING) {
//            System.out.println("PC: " + pc.getValue());
//            this.fetch();
//            this.decode();
//            this.execute();
//        }
//    }
//
//    private void fetch() {
//        mar.setPageNum(cs.getValue());
//        mar.setOffSet(pc.getValue());
//        memory.loadInstruction();
//        ir.setInstructionSet(mbr.getInstructionSet());
//    }
//
//    private void decode() {
//        for(SInstructionSet.InstructionSet instruction : SInstructionSet.InstructionSet.values()) {
//            if (instruction.getOpCode().equals(ir.getOperator())) {
//                operator = instruction;
//            }
//        }
//    }
//
//    private void execute() {
//        pc.setValue(pc.getValue() + 1);
//        switch (operator) {
//            case ADDA: this.adda(); break;
//            case ADDC: this.addc(); break;
//            case SUBA: this.suba(); break;
//            case SUBC: this.subc(); break;
//            case MULA: this.mula(); break;
//            case MULC: this.mulc(); break;
//            case DIVA: this.diva(); break;
//            case DIVC: this.divc(); break;
//            case JMP: this.jmp(); break;
//            case BZJ: this.bzj(); break;
//            case EQJ: this.eqj(); break;
//            case LDA: this.lda(); break;
//            case LDC: this.ldc(); break;
//            case STO: this.sto(); break;
//            case STOA: this.stoa(); break;
//            case PUSH: this.push(); break;
//            case POP: this.pop(); break;
//            case NEW: this.newh(); break;
//            case IN: this.input(); break;
//            case OUT: this.output(); break;
//            case HALT: this.halt(); break;
//            default: break;
//        }
//    }
//
//    private void newh() {
//        memory.allocateHeap(Integer.parseInt(ir.getOperand(), 16));
//    }
//
//    private void stoa() {
//        int address = Integer.parseInt(memory.loadValue(Integer.parseInt(ir.getOperand(), 16)), 16);
//        memory.setAddress(address);
//        memory.store(ac.getValue());
//    }
//
//    private void sto() {
//        memory.setAddress(Integer.parseInt(ir.getOperand(), 16));
//        memory.store(ac.getValue());
//    }
//
//    private void output() {
//        String value = memory.loadValue(Integer.parseInt(ir.getOperand(), 16));
//        String que = String.valueOf(Integer.parseInt(value, 16));
//        System.out.println(que);
//    }
//
//    private void input() {
//        Scanner scanner = new Scanner(System.in);
//        ac.setValue(Integer.parseInt(scanner.nextLine()));
//        scanner.close();
//    }
//
//    public void adda() {
//        String value = memory.loadValue(Integer.parseInt(ir.getOperand(), 16));
//        ac.setValue(ac.getValue() + Integer.parseInt(value, 16));
//    }
//
//    public void addc() {
//        ac.setValue(ac.getValue() + Integer.parseInt(ir.getOperand(), 16));
//    }
//    public void suba() {
//        String value = memory.loadValue(Integer.parseInt(ir.getOperand(), 16));
//        ac.setValue(ac.getValue() - Integer.parseInt(value, 16));
//    }
//
//    public void subc() {
//        ac.setValue(ac.getValue() - Integer.parseInt(ir.getOperand(), 16));
//    }
//
//    private void mula() {
//        String value = memory.loadValue(Integer.parseInt(ir.getOperand(), 16));
//        ac.setValue(ac.getValue() * Integer.parseInt(value, 16));
//    }
//
//    private void mulc() {
//        ac.setValue(ac.getValue() * Integer.parseInt(ir.getOperand(), 16));
//    }
//
//    private void diva() {
//        String value = memory.loadValue(Integer.parseInt(ir.getOperand(), 16));
//        ac.setValue(ac.getValue() / Integer.parseInt(value, 16));
//    }
//
//    private void divc() {
//        ac.setValue(ac.getValue() / Integer.parseInt(ir.getOperand(), 16));
//    }
//
//    private void jmp() {
//        pc.setValue(Integer.parseInt(ir.getOperand(),16) - 1);
//    }
//
//    private void bzj() {
//        if(ac.getValue() < 0){
//            pc.setValue(Integer.parseInt(ir.getOperand(),16) - 1);
//        }
//    }
//
//    private void eqj() {
//        if(ac.getValue() == 0){
//            pc.setValue(Integer.parseInt(ir.getOperand(),16) - 1);
//        }
//    }
//
//    private void lda() {
//        String value = memory.loadValue(Integer.parseInt(ir.getOperand(), 16));
//        ac.setValue(Integer.parseInt(value, 16));
//    }
//    private void ldc() {
//        ac.setValue(Integer.parseInt(ir.getOperand(), 16));
//    }
//
//    private void push() {
//        sl.setValue(sp.getValue());
//        sp.setValue(sp.getValue() + Integer.parseInt(ir.getOperand(),16));
//    }
//    private void pop() {
//        sp.setValue(sl.getValue());
//    }
//
//    public void halt() {
//        this.estate = Estate.eSTOPPED;
//    }
//}
