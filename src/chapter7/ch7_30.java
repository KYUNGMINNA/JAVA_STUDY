package chapter7;

public class ch7_30 {

    public static void main(String[] args) {

        Child30 c= new Child30();
        c.method1();
        c.method2();
        MyInterface30.staticMethod();
        MyInterface30_2.staticMethod();
    }

}
class Child30 extends Parent30 implements MyInterface30,MyInterface30_2{
    public void method1(){
        System.out.println("method1() in Child");
    }
}
class Parent30{
    public void method2(){
        System.out.println("method2() in Parent ");
    }

}
interface MyInterface30{
    default void method1(){
        System.out.println("method1() in Myinterface30");
    }
    default void method2(){
        System.out.println("method1() in Myinterface30");
    }
    static void staticMethod(){
        System.out.println("method1() in Myinterface30");
    }

}
interface MyInterface30_2{

    default void method1(){
        System.out.println("method1() in Myinterface30_2");
    }
    static void staticMethod(){
        System.out.println("method1() in Myinterface30_2");
    }
}