package java_example.chapter07;

public class ch7_18 {
    public static void main(String[] args) {

        Parent18 p=new Child18();
        Child18 c=new Child18();
        System.out.println("p.x :"+p.x);

        p.method();

        System.out.println("c.x :"+c.x);
        c.method();
    }
}
class Parent18{
    int x=100;
    void method(){
        System.out.println("Parent method()");
    }
}
class Child18 extends Parent18{
    int x=200;

    void method(){
        System.out.println("Child method");
    }
}
