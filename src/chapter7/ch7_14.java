package chapter7;

public class ch7_14 {
    public static void main(String[] args) {

        //Singleton14 s=new Singleton14();
        Singleton14 s=Singleton14.getInstance();
    }

}
final class Singleton14{
    private static Singleton14 s=new Singleton14();

    private Singleton14(){
        //
    }
    public static Singleton14 getInstance(){
        if(s==null){
            s=new Singleton14();


        }
        return s;
    }
}