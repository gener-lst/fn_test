package memoryManagement;

import java.util.HashMap;
import java.util.Map;

public class SPageTable {
    private Map<Integer, Integer> pageTable;

    public SPageTable() {
        pageTable = new HashMap<>();
    }

    public void addPage(int pageNumber, int physicalAddress) {
        pageTable.put(pageNumber, physicalAddress);
    }

    public int getPhysicalAddress(int pageNumber) {
        Integer physicalAddress = pageTable.get(pageNumber);
        if (physicalAddress != null) {
            return physicalAddress;
        }
        return -1; // 페이지 번호에 해당하는 물리 주소를 찾지 못한 경우
    }

    public int searchKey() {
        boolean exflag = false;
        for(int i = 0; i < pageTable.size(); i++) {
            for(Integer key : pageTable.keySet()) {
                if(key == i) {
                    exflag = true;
                }
            }
            if(!exflag) {
                return i;
            }
        }
        return pageTable.size();
    }

    public int searchValue() {
        boolean exflag = false;
        for(int i = 0; i < pageTable.size(); i++) {
            for(Integer value : pageTable.values()) {
                if(value == i) {
                    exflag = true;
                }
            }
            if(!exflag) {
                return i;
            }
        }
        return pageTable.size();
    }
}
