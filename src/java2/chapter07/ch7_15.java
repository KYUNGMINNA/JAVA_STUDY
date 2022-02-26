package java2.chapter07;

public class ch7_15 {

    public static void main(String[] args) {

        Car15 car=null;
        FireEngine15 fe=new FireEngine15();
        FireEngine15 f2=null;

        fe.water();
        car=fe;
        f2=(FireEngine15) car;
        f2.water();
    }
}
class Car15{
    String color;
    int door;

    void drive(){
        System.out.println("drive ,Brrr~~");
    }
    void stop(){
        System.out.println("stop!");
    }

}
class FireEngine15 extends Car15{
    void water(){
        System.out.println("water!");
    }
}