package java.chapter13;

public class ch13_22 {
    public static void main(String[] args) {
        Runnable r=new RunnableEx22();
        new Thread(r).start();
        new Thread(r).start();
    }
}
class Account22 {
    private  int balacne=1000;

    public int getBalacne(){
        return balacne;
    }
    public synchronized void withdraw(int money){
        if (balacne>=money){
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){

            }
            balacne-=money;
        }
    }
}
class  RunnableEx22 implements Runnable{
    Account22 ac=new Account22();

    @Override
    public void run() {
        while(ac.getBalacne() >0 ){
            int money=(int)(Math.random()*3+1)*100;
            ac.withdraw(money);
            System.out.println("balance : "+ac.getBalacne());
        }
    }
}