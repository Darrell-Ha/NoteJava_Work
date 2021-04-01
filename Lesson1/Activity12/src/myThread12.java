public class myThread12 extends Thread{
    private String nameThread;
    private int sleepsec;

    public myThread12(String nameThread, int sleepsec) {
        this.nameThread=nameThread;
        this.setName(nameThread);
        this.sleepsec = sleepsec;
    }
    public synchronized void run(){
        try {
            Thread.sleep(sleepsec);
            System.out.println("Đã chạy xong thread: "+getName()+" sau : "+sleepsec+"milis");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
