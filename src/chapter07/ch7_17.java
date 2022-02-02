package chapter07;

public class ch7_17 {
    public static void main(String[] args) {

        FireEngine17 fe=new FireEngine17();

        if (fe instanceof FireEngine17){
            System.out.println("This is a FireEngine instance");
        }

        if (fe instanceof Car17){
            System.out.println("This is a Car instance");
        }
        if (fe instanceof Object){
            System.out.println("This is an Object instance");
        }
        System.out.println(fe.getClass().getName());
    }
}
class Car17{}
class FireEngine17 extends Car17{}
