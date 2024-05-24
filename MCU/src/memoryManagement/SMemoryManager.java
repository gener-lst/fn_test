package memoryManagement;

public class SMemoryManager {
    public void run() {
        // 페이지 테이블 생성 및 페이지 추가
//        pageTable.addPage(0, 1500);
//        pageTable.addPage(1, 3500);
//
//        // 가상 주소 변환
//        int segmentNumber = 0;
//        int pageNumber = 0;
//        int virtualAddress = 1200;
//
//        int baseAddress = segmentTable.getBaseAddress(segmentNumber);
//        int limitAddress = segmentTable.getLimitAddress(segmentNumber);
//        int offset = virtualAddress - baseAddress;
//        if (offset >= 0 && offset <= limitAddress) {
//            int physicalAddress = pageTable.getPhysicalAddress(pageNumber);
//            if (physicalAddress != -1) {
//                int finalAddress = physicalAddress + offset;
//                System.out.println("Physical Address: " + finalAddress);
//            } else {
//                System.out.println("Page not found in Page Table");
//            }
//        } else {
//            System.out.println("Virtual Address not valid for the given Segment");
//        }
    }

    public int set(SPageTable pageTable, int pageSize, int segmentSize) {
        int allocatePage = (int) Math.ceil((double) segmentSize/pageSize);
        int pageNum = 0, frameNum;
        int baseNum = pageTable.searchKey();
        for(int i = 0; i < allocatePage; i++) {
            pageNum = pageTable.searchKey();
            frameNum = pageTable.searchValue();
            pageTable.addPage(pageNum, frameNum);
        }
        return baseNum;
    }
}