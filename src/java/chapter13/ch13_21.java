package java.chapter13;

public class ch13_21 {
    public static void main(String[] args) {
        Runnable r=new RunnableEx21();
        new Thread(r).start();
        new Thread(r).start();
    }
}
class Account {
    private  int balacne=1000;

    public int getBalacne(){
        return balacne;
    }
    public void withdraw(int money){
        if (balacne>=money){
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){

            }
            balacne-=money;
        }
    }
}
class  RunnableEx21 implements Runnable{
    Account ac=new Account();

    @Override
    public void run() {
        while(ac.getBalacne() >0 ){
            int money=(int)(Math.random()*3+1)*100;
            ac.withdraw(money);
            System.out.println("balance : "+ac.getBalacne());
        }
    }
}