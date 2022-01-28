package chapter7;

public class ch7_05 {
    public static void main(String[] args) {

        Child5 ch=new Child5();
        ch.method();
    }

}
class Parent5{
    int x=10;
}
class Child5 extends  Parent5{
    void method(){
        System.out.println("x= :"+x);
        System.out.println("super.x :"+super.x);
        System.out.println("this.x : "+this.x);
    }
}
