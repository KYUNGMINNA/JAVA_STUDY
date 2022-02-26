package java2.chapter13;

public class ch13_03 {
    public static void main(String[] args) {
        ThreadEx3_1 t1=new ThreadEx3_1();
        t1.run();

        Thread t2=new Thread(new ThreadEx3_2());
        t2.run();
    }
}
class ThreadEx3_1 extends Thread{
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
class ThreadEx3_2 implements Runnable{
    @Override
    public void run() {
        throwException();
    }
    public void throwException(){
        try {
            throw new Exception();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}