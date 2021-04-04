import java.util.HashMap;
import java.util.Random;

public class Program14 {
    public static String aDay = "";
    public static HashMap<String,String> week = new HashMap<>();
    public static boolean flag = false;
    public static void main(String[] args) {
        week.put("Monday", "Thứ hai");
        week.put("Tuesday", "Thứ ba");
        week.put("Wednesday", "Thứ tư");
        week.put("Thursday", "Thứ năm");
        week.put("Friday", "Thứ sáu");
        week.put("Saturday", "Thứ bảy");
        week.put("Sunday", "Chủ nhật");
        //dayOfWeek = week.keySet();
        PickADay pickDay = new PickADay();
        pickDay.start();
        Translate trans = new Translate();
        trans.start();


    }
}
class PickADay extends Thread{
    private String [] weekInArr = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
    public synchronized void run(){
        while (true){
            Random rand = new Random();
            if(!Program14.flag){
                Program14.flag = true;
                Program14.aDay = weekInArr[rand.nextInt(7)];
                System.out.println("Thread - Pick A Day: "+ Program14.aDay);
                Program14.flag = false;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

}
class Translate extends Thread{
    public synchronized void run(){
        while (true){
            if(!Program14.flag){
                Program14.flag = true;
                System.out.println("Thread - Translate: " + Program14.week.get(Program14.aDay));
                Program14.flag = false;
                try {
                    Thread.sleep(990);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
