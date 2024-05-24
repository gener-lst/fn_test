import java.util.Scanner;
import java.util.Vector;

public class Score {
    int num;
    int sumAll;
    int avgAll;
    Scanner scanner;
    Student[] students;

//    public int getSum() {
//        return sumAll;
//    }
//
//    public int getAvg() {
//        return avgAll;
//    }

    public Score() {

    }

    public void read() {
        scanner = new Scanner(System.in);
        Student student = new Student();
        System.out.println("학생 수를 입력하시오.");
        num = Integer.parseInt(scanner.nextLine());
        students = new Student[num];
        for(int i = 1; i <= num; i++) {
            System.out.println("학생" + i + "의 영어점수를 입력하시오.");
//            student.setEngScore(Integer.parseInt(scanner.nextLine()));
            student.engScore = (Integer.parseInt(scanner.nextLine()));
            System.out.println("학생" + i + "의 국어점수를 입력하시오.");
//            student.setKorScore(Integer.parseInt(scanner.nextLine()));
            student.korScore = (Integer.parseInt(scanner.nextLine()));
            students[i - 1] = student;
        }
    }

    public int sum(int engScore, int korScore) {
        int sum = engScore + korScore;
        return sum;
    }

    public int avg(int sum) {
        int avg = sum / (num * 2);
        return avg;
    }


    public void calculate() {
        int sum = 0;
//        for(Student student : students) {
//            sum = sum(student.getEngScore(), student.getKorScore()) + sum;
//        }
        for(int i = 0; i <num; i++) {
            sum = sum(students[i].engScore, students[i].korScore) + sum;
        }
        sumAll = sum;
        avgAll = avg(sum);
    }
}
