package chapter07;

public class ch7_16 {

    public static void main(String[] args) {

        Car16 car=new FireEngine16();

        Car16 car2=null;
        FireEngine16 fe=null;

        car.drive();
        //fe=(FireEngine16) car; -- 자손타입의 참조변수로 조상타입의 인스턴스 참조 불가!

        fe=(FireEngine16)car;

        fe.drive();

        car2=fe;
        car2.drive();
    }
}

class Car16{
    String color;
    int door;

    void drive(){
        System.out.println("drive ,Brrr~~");
    }
    void stop(){
        System.out.println("stop!");
    }

}
class FireEngine16 extends Car16{
    void water(){
        System.out.println("water!");
    }
}

