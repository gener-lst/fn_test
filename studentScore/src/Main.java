public class Main {
    public static void main(String [] args) {
        Score score = new Score();
        score.read();
        score.calculate();
//        System.out.println("전체 총합: " + score.getSum() + " 전체 평균: " + score.getAvg());
        System.out.println("전체 총합: " + score.sumAll + " 전체 평균: " + score.avgAll);
    }
}
