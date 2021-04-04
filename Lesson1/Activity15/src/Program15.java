import java.util.Random;

public class Program15 {
    public static void main(String[] args) {
        Random rand = new Random();
        BankAccount bankOfUs = new BankAccount();
        WithdrawThread wife = new WithdrawThread("Wife", bankOfUs, 2340000);
        WithdrawThread husband =  new WithdrawThread("Husband", bankOfUs, 1664000);
        int bool = rand.nextInt(2);
        if (bool == 1 ){
            husband.start();
            wife.start();
        }else{
            wife.start();
            husband.start();
        }


    }
}
class BankAccount {
    private long amount = 20000000;
    private long delta = 20000000;
    private boolean flag = false;
    public long getDelta(){
        return delta;
    }
    public long getAmount(){
        return amount;
    }
    //public void setFlag(boolean flag){
        //this.flag = flag;
    //}
    public synchronized long withdraw(String threadName, long withdrawAmount){
        this.delta = amount - withdrawAmount;
        if(withdrawAmount <= amount){
            this.amount = delta;
            System.out.println(threadName + " đã rút thành công "+withdrawAmount+" " +
                    "|| Số dư còn lại sau khi "+threadName+" rút: "+amount);
            return withdrawAmount;
        }else {
            System.out.println(threadName + " không thể rút "+withdrawAmount+" được, số dư là " + amount);
            return 0;
        }

    }
}
class WithdrawThread extends Thread{
    private  String name ;
    private  long withdrawAmount;
    private BankAccount bank ;
    private long withdrawed;

    public WithdrawThread (String name, BankAccount bank, long withdrawAmount){
        this.name = name;
        this.bank = bank;
        this.withdrawAmount = withdrawAmount;
    }
    public void run(){
        while (bank.getDelta()>0) {
                this.withdrawed += bank.withdraw(name, withdrawAmount);
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            //}
        }
        /// Chỗ này test thì em thấy không cần để synchronized ///
        System.out.println("=================================");
        System.out.println(name + " đã rút được: " + withdrawed);
        System.out.println("Số dư cuối cùng: " + bank.getAmount());
    }

}
