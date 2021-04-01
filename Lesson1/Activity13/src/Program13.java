import java.util.Random;

public class Program13 {
    public static int year;
    public static void main(String[] args) {
        GenerateYear genYear = new GenerateYear();
        Checking checkYear = new Checking();
        while (true) {
            genYear.run();
            checkYear.run();

        }
    }
}
class GenerateYear extends Thread{
    private static final int timeSleep =2000;
    //private int year;
    public  void run(){
        try {
            Random randYear = new Random();
            int yearGen = randYear.nextInt(9999 - 1000 + 1) + 1000;
            System.out.println("Xét năm " + yearGen + " lúc: " + System.currentTimeMillis() + "  ");
            Program13.year = yearGen;
            Thread.sleep(timeSleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //int generateYear() {
    //    run();
    //    return year;
    //}
}
class Checking extends Thread{
    //private int year;
    private int timeSleep=2000;
    public  synchronized void run(){
        if (Program13.year % 4 == 0) {
                if (Program13.year % 100 == 0) {
                    System.out.println(Program13.year + " không phải năm nhuận");
                } else {
                    System.out.println(Program13.year + " là năm nhuận");
                }
        } else if (Program13.year % 400 == 0) {
                System.out.println(Program13.year + " là năm nhuận");
        }


    }
    //void set_andCheckYear(int year) {
        //this.year = year;
    //    run();
    //}
}
