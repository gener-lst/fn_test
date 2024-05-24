import Register.MAR;
import Register.MBR;
import Register.Register;
import memoryManagement.SMemoryManager;
import memoryManagement.SPageTable;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Memory {
    public static final int MEMORY_SIZE = 1024;
    public static final int PAGE_SIZE = 64;

    private Scanner scanner;
    private String[][] memory;
    private SPageTable pageTable;
    private SMemoryManager memoryManager;
    private MAR MAR;
    private MBR MBR;
    private Register CS;
    private Register DS;
    private Register SS;
    private Register HS;

    private SKeyboard keyboard;
    private int numPages;
    public Memory() {
        this.numPages = MEMORY_SIZE / PAGE_SIZE;
        this.memory = new String[numPages][PAGE_SIZE];
    }

    public void associate(MAR MAR, MBR MBR, Register CS, Register DS, Register SS, Register HS, SKeyboard keyboard) {
        this.MAR = MAR;
        this.MBR = MBR;
        this.CS = CS;
        this.DS = DS;
        this.SS = SS;
        this.HS = HS;
        this.keyboard = keyboard;
        this.pageTable = new SPageTable();
        this.memoryManager = new SMemoryManager();
    }

    public void read() {
        try{
            scanner = new Scanner(new File("source/objectCode"));
            CS.setValue(memoryManager.set(pageTable, PAGE_SIZE, Integer.parseInt(scanner.nextLine(), 16)));
            DS.setValue(memoryManager.set(pageTable, PAGE_SIZE, Integer.parseInt(scanner.nextLine(), 16)));
            SS.setValue(memoryManager.set(pageTable, PAGE_SIZE, Integer.parseInt(scanner.nextLine(), 16)));
            HS.setValue(memoryManager.set(pageTable, PAGE_SIZE, Integer.parseInt(scanner.nextLine(), 16)));
            scanner.nextLine();

            int row = pageTable.getPhysicalAddress(CS.getValue());
            int col = 0;
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    break;
                }
                if(col == PAGE_SIZE) {
                    row += 1;
                    col = 0;
                }
                memory[row][col] = input;
                col += 1;
            }

            row = pageTable.getPhysicalAddress(DS.getValue());
            col = 0;
            while (scanner.hasNext()) {
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    break;
                }
                if(col == PAGE_SIZE) {
                    row += 1;
                    col = 0;
                }
                memory[row][col] = input;
                col += 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\n<Memory>\n");
        System.out.println("cs:" + CS.getValue() + " ds:" + DS.getValue() + " ss:" + SS.getValue() + " hs:" + HS.getValue());
        for(String[] row : memory) {
            for(String data : row) {
                if(data != null) {
                    System.out.println(data);
                }
            }
        }
    }

//    public void load() {
//        int address = MAR.getValue();
//        MBR.setInstructionSet(this.memory.get(address));
//    }
//
//    public void store() {
//        int address = MAR.getAddress();
//        String value = Integer.toString(MBR.getValue(), 2);
//        if(address >= memory.size()) {
//            while(address > memory.size()) {
//                this.memory.add(memory.size(), null);
//            }
//            this.memory.add(address, value);
////            System.out.println("memoryAddress:" + address + " value:" + value);
//        } else {
//            this.memory.set(address, value);
////            System.out.println("count:" + memory.get(35) + " sum:" + memory.get(39) + " i:" + memory.get(43));
////            System.out.println("count:" + Integer.parseInt(memory.get(35), 2) + " sum:" + Integer.parseInt(memory.get(39), 2) + " i:" + Integer.parseInt(memory.get(43), 2));
//        }
//    }
//
//    public void lda() {
//        int address = MAR.getAddress();
//        MBR.setValue(Integer.parseInt(this.memory.get(address), 2));
//    }
//
//    public void ldi() {
//    }
}
