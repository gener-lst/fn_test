import java.util.Scanner;
import java.util.Vector;

public class SKeyboard {
    private Scanner scanner;
    private Vector<String> IOMemory;

    SKeyboard() {
        scanner = new Scanner(System.in);
        IOMemory = new Vector<>();
    }

    private void callback(int i) {
        IOMemory.get(i);
    }
}
