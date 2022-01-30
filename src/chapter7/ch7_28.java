package chapter7;


public class ch7_28 {
    public static void main(String[] args) {

        A28 a=new A28();
        a.autoPlay(new B28());
        a.autoPlay(new C28());
    }
}
class A28{
    void autoPlay(I28 i){
        i.play();
    }
}
interface I28{
    public abstract void play();
}
class B28 implements I28{

    public void play() {
        System.out.println("play in B class");
    }
}
class C28 implements I28{
    public void play() {
        System.out.println("play in C class");
    }

}