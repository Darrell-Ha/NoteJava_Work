

public class Program16 {
    public static int solutionMax=0;
    public static int countDiv = 0;
    public static long time=0;
    public static int countThread =0;
    public static void main(String[] args) {
        Thread check1 = new Thread(new CheckNumber(1,20000));
        Thread check2 = new Thread(new CheckNumber(20001,40000));
        Thread check3 = new Thread(new CheckNumber(40001,60000));
        Thread check4 = new Thread(new CheckNumber(60001,80000));
        Thread check5 = new Thread(new CheckNumber(80001,100000));
        check1.start();
        check2.start();
        check3.start();
        check4.start();
        check5.start();
        while (true){
            if(countThread==5){
                break;
            }
        }
        System.out.println("Main: Max= "+solutionMax+", count= "+countDiv+", runtime= "+ time);
    }

}
class CheckNumber implements Runnable {
    private int begin;
    private int end;
    private int maxQuantDiv=0;
    private int quant=0;
    public CheckNumber (int begin, int end){
        this.begin=begin;
        this.end=end;
    }

    @Override
    public void run() {
        long start=System.currentTimeMillis();
        for(int i = this.begin; i<this.end+1;i++){
            int countMax=0;
            int maxSolution = i;
            for(int div = 1; div<=i; div++){
                if(i%div==0){
                    countMax++;
                }
            }
            if(countMax>this.quant){
                this.quant=countMax;
                this.maxQuantDiv=maxSolution;
            }
        }
        if (this.quant>Program16.countDiv){
            Program16.countDiv=this.quant;
            Program16.solutionMax=this.maxQuantDiv;
        }
        long end = System.currentTimeMillis();
        Program16.time+=end-start;
        System.out.println(Thread.currentThread().getName()+"Finished!,"+(end-start)+"ms, Max= "+this.maxQuantDiv+
                ", count = "+this.quant);
        Program16.countThread++;
    }
}
