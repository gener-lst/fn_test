package Compiler.component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SLex {
    private Scanner scanner;
    public SLex() {}

    public void initialize(String fileName) {
        try {
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("파일이 존재하지 않습니다.");
        }
//        System.out.println("<tokens>");
    }

    public void finalize() {
        scanner.close();
    }

    public String getToken() {
        if(scanner.hasNext()) {
            String token = scanner.next().trim();
//            System.out.println(token);
            return token;
        }
        return null;
    }

    public String[] getTokens() {
        if(scanner.hasNext()) {
            String line = scanner.nextLine().trim();
            String[] tokens = line.split(" ");
//            for(int i = 0; i < tokens.length; i++) {
//                if(tokens[i].length() != 0) {
//                    System.out.println(tokens[i]);
//                }
//            }
            return tokens;
        }
        return null;
    }
}