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
    private int CSS, DSS, SSS, HSS;

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
            CSS = Integer.parseInt(scanner.nextLine(), 16);
            CS.setValue(memoryManager.set(pageTable, PAGE_SIZE, CSS));
            DSS = Integer.parseInt(scanner.nextLine(), 16);
            DS.setValue(memoryManager.set(pageTable, PAGE_SIZE, DSS));
            SSS = Integer.parseInt(scanner.nextLine(), 16);
            SS.setValue(memoryManager.set(pageTable, PAGE_SIZE, SSS));
            HSS = Integer.parseInt(scanner.nextLine(), 16);
            HS.setValue(memoryManager.set(pageTable, PAGE_SIZE, HSS));
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
        System.out.println("\n<Memory>");
        System.out.println("cs:" + CS.getValue() + " ds:" + DS.getValue() + " ss:" + SS.getValue() + " hs:" + HS.getValue());
        for(String[] row : memory) {
            for(String data : row) {
                if(data != null) {
                    System.out.println(data);
                }
            }
        }
    }
//
//    public void loadInstruction() {
//        int pageNum = pageTable.getPhysicalAddress(MAR.getPageNum());
//        int offSet = MAR.getOffSet();
//        if(offSet == PAGE_SIZE){
//            pageNum += 1;
//            offSet -= 64;
//        }
//        MBR.setInstructionSet(this.memory[pageNum][offSet]);
//    }
//
//    public String loadValue(int address) {
//        int pageNum = 0;
//        int offSet = 0;
//        if (address >= CSS && address < DSS) {
//            pageNum = DS.getValue();
//            offSet = address - DSS;
//        } else if (address < SSS) {
//            pageNum = SS.getValue();
//            offSet = address - SSS;
//        } else {
//            pageNum = HS.getValue();
//            offSet = address - HSS;
//        }
//        return this.memory[pageNum][offSet];
//    }
//
//    public void setAddress(int address) {
//        int pageNum = 0;
//        int offSet = 0;
//        if (address >= CSS && address < DSS) {
//            pageNum = DS.getValue();
//            offSet = address - DSS;
//        } else if (address < SSS) {
//            pageNum = SS.getValue();
//            offSet = address - SSS;
//        } else {
//            pageNum = HS.getValue();
//            offSet = address - HSS;
//        }
//        MAR.setPageNum(pageNum);
//        MAR.setOffSet(offSet);
//    }
//
//    public void store(int value) {
//        int pageNum = pageTable.getPhysicalAddress(MAR.getPageNum());
//        int offSet = MAR.getOffSet();
//        String stoValue = Integer.toString(value, 16);
//
//        this.memory[pageNum][offSet] = stoValue;
//    }
//
//    public void allocateHeap(int size) {
//        String value = this.memory[HS.getValue()][size];
//    }
}
