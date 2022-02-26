package java2.chapter13;

public class ch13_19 {
    static long starttime=0;
    public static void main(String[] args) {


        ThreadEx19_1 th1 = new ThreadEx19_1();
        ThreadEx19_2 th2 = new ThreadEx19_2();

        Thread th3=new Thread(new RunnalbeEx19_2());

        th1.start();
        th2.start();

        th3.start();


        starttime=System.currentTimeMillis();

        try{
            th1.join();
            th2.join();

            th3.join();
        }catch (InterruptedException e){

        }
        System.out.println("소요 시간 : "+(System.currentTimeMillis()-starttime));
    }
}
class ThreadEx19_1 extends Thread{
    @Override
    public void run() {
        for(int i=0;i<300;i++){
            System.out.print(new String("-"));
        }
    }
}
class ThreadEx19_2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print(new String("|"));
        }
    }
}
class RunnalbeEx19_2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print(new String("*"));
        }
    }
}