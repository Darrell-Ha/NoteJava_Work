public class Program12 {
    public static void main(String[] args) {
        myThread12 thread1 = new myThread12("ABC",3500);
        myThread12 thread2 = new myThread12("DEF",2500);
        thread1.start();
        thread2.start();
    }
}
