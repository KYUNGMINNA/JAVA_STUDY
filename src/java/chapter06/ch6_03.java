package java.chapter06;

class TV3{
    String color;
    boolean power;
    int channel;

    void power(){power=!power;}
    void channelUp(){++channel;}
    void channelDown(){--channel;}
}
public class ch6_03 {
    public static void main(String[] args) {
        TV3 t1=new TV3();
        TV3 t2=new TV3();

        System.out.println("t1의 channel의 값은"+ t1.channel+"입니다");
        System.out.println("t2의 channel 의 값은"+t2.channel+"입니다");
        t2=t1;
        System.out.println("t2=t1 참조변수 t1이 저장하고 있는 주소를 t2에 복사한다. t2가 참조 하고 있던 인스턴스는 더이상 사용 되지 않아 Garbage collector가 메모리에서 정리한다");
        t1.channel=7;
        System.out.println("t1의 channel의 값을 7로 변경합니다.");
        System.out.println("t1의 채널의 값은"+t1.channel+"입니다");
        System.out.println("t2의 채널의 값은"+t2.channel+"입니다.");
    }
}
