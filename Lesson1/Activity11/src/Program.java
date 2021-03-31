public class Program {
    public static void main(String[] args) {
        for(int i=0; i<50; i++){
            myThread thread = new myThread();
            thread.start();
        }
    }
}
class myThread extends Thread{
    public void run(){
        System.out.println(this.getId());
    }
}