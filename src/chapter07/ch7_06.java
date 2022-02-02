package chapter07;

public class ch7_06 {
    public static void main(String[] args) {

        Child6 ch=new Child6();
        ch.method();
    }

}
class Parent6{
    int x=10;
}
class Child6 extends Parent6{
    int x=20;
    void method(){
        System.out.println("X = :"+x);
        System.out.println("super.x : "+super.x);
        System.out.println("this.x :"+this.x);
    }
}
