package java_example.chapter13;

public class ch13_02 {
    public static void main(String[] args) {

        ThreadEx2_1 t1=new ThreadEx2_1();
        t1.start();

        Thread t2=new Thread(new ThreadEx2_2());
        t2.start();
    }
}
class ThreadEx2_1 extends Thread{
    public void run(){
        throwException();
    }
    public void throwException(){
        try{
            throw new Exception();
        }catch (Exception e ){
            e.printStackTrace();
        }
    }
}
class ThreadEx2_2 implements Runnable{
    public void run(){
        throwException2();
    }
    public void throwException2(){
        try {
            throw new Exception();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}