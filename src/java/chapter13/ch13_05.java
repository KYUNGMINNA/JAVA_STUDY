package java.chapter13;

public class ch13_05 {
    static long startTime=0;
    static long startTime2=0;

    public static void main(String[] args) {

        ThreadEx5_1 th1 =new ThreadEx5_1();
        th1.start();
        startTime=System.currentTimeMillis();

        for (int i=0;i<300;i++){
            System.out.printf("%s",new String("-"));

        }
        System.out.println("소요 시간 1"+(System.currentTimeMillis()-startTime));


        Thread th2=new Thread(new ThreadEx5_2());
        th2.start();
        startTime2=System.currentTimeMillis();

        for (int i=0;i<300;i++){
            System.out.printf("%s",new String("-"));

        }
        System.out.println("소요 시간 1_2"+(System.currentTimeMillis()-startTime));



    }
}
class ThreadEx5_1 extends Thread{
    public void run(){
        for (int i=0;i<300;i++){
            System.out.printf("%s",new String("|"));

        }
        System.out.println("소요 시간 2"+(System.currentTimeMillis()-ch13_05.startTime));
    }
}

class ThreadEx5_2 implements Runnable {
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.printf("%s", new String("|"));

        }
        System.out.println("소요 시간 2_2" + (System.currentTimeMillis() - ch13_05.startTime));

    }
}