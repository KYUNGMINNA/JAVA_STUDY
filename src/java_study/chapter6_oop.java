package java_study;

class sub_class{

    //2.클래스와 객체
    //멤버 변수=속성,특성,필드,상태
    String color;
    boolean power;
    int channel;


    //메서드=기능,함수,행위
    void power(){power=!power;}
    void channelUp(){++channel;}
    void channelDown(){--channel;}
}

class variable_method {
    //3.변수와 메서드

    int iv;    //  클래스 영역에 있는 인스턴스 변수 , 초기화 생략 가능
    static int cv;  //클래스 영역에 있는 클래스 변수, 초기화 생략 가능

    //반환형이 없는 인스턴스 메서드
    void method() {
        int lv = 0;     //클래스 영역 이외의 영역에 있는 지역변수로 사용하려면 초기화 해야한다.
    }


    //인스턴스 변수 -- 인스턴스마다 각기 다른 값 유지
    String kind;
    int number;

    //클래스 변수 -- 공통의 값으로 사용
    static int width = 100;
    static int height = 200;

    //반환 값이 있는 인스턴스메서드는 return값이 존재
    int add(int x,int y){
        return x+y;
    }
    //반환 값 없는 인스턴스 메서드
    void print(int x){
        System.out.println("반환값 없는 메서드 호출");
    }


}
public class chapter6_oop {
    public static void main(String[] args) {

        //2.클래스와 객체
        sub_class sub=new sub_class(); //클래스 객체 타입의 참조변수 선언  +new연산자로 클래스의 인스턴트 생성 +클래스 생성자에 의해 기본값으로 초기화
        sub.channel=7;  //인스턴스의 멤버변수 사용
        sub.channelUp(); //인스턴스의 메서드 호출
        // 인스턴스는 참조변수를 통해서만 다룰 수 있으며 ,참조변수의 타입은 인스턴스의 타입과 일치해야한다.

        //객체 배열

        //sub_class[] subarr=new sub_class[3];
        sub_class[] subarr={new sub_class(),new sub_class(),new sub_class()};
        for(int i=0;i<subarr.length;i++){
            subarr[i]=new sub_class();
            subarr[i].channel=i+10;
        }
        for(int i=0;i<subarr.length;i++) {
            subarr[i].channelUp();
        }


        //3.변수와 메서드
        System.out.println(variable_method.height);
        System.out.println(variable_method.width);
        variable_method var1=new variable_method();
        var1.kind="heart";
        var1.number=7;

        variable_method var2=new variable_method();
        var2.kind="spade";
        var2.number=4;

        System.out.println(var1.kind+var1.number+var1.width+var1.height);
        System.out.println(var2.kind+var2.number+var2.width+var2.height);
        var1.width=50;
        var1.height=70;
        System.out.println("var1.width  height 값 변경 이후");
        System.out.println(var1.kind+"  "+var1.number+"  "+var1.width+" "+var1.height);
        System.out.println(var2.kind+"  "+var2.number+"  "+var2.width+" "+var2.height);


        //메서도 호출 ( 객체 생성 과정 필요)
        variable_method methodcall=new variable_method();
        //반환 값 있는 메서드 호출
        int result=methodcall.add(1,2);
        //반환값 없는 메서도 호출
        methodcall.print(1);

    }





        }
