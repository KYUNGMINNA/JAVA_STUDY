package chapter6;

class TV2{
    String color;
    boolean power;
    int channel;

    void power(){power=!power;}
    void channelUp(){++channel;}
    void channelDown(){--channel;}

}
public class ch6_02 {
    public static void main(String[] args) {
        TV2 t1=new TV2();
        TV2 t2=new TV2();

        System.out.println("t1의 channel의 값은"+t1.channel+"입니다");
        System.out.println("t2의 channel의 값은"+t2.channel+"입니다");

        t1.channel=7;
        System.out.println("t1 의 채널의 값을 7로 변경하였습니다.");
        System.out.println("t1의  channel의 값은"+t1.channel+"입니다");
        System.out.println("t2의 channel의 값은"+t2.channel+"입니다.");

    }
}
