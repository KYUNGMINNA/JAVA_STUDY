package java2.java_study;


import java.util.Scanner;

public class chapter2_variable {
    public static void main(String[] args) {

        boolean b=true,bb=false;  //1byte

        char c='a';  //2byte
        int c1=(int)c;

        byte y=0;     //1byte
        short s=0;    //2byte
        int i=0;      //4byte
        long l=123L;  //8byte

        int binnum=0b10;  //2진수
        int octnum=010;    //8진수
        int hexnum=0x10;   //16진수

        float f=1.0f,ff=1.0F; //4 byte , 10진수 7자리의 정확도
        double d=2.34,dd=2.34d,ddd=2.34D; //8  10진수 15자리 정확도

        double e1=1e+10,e2=-3e-10;

        //참조형
        String st="test";


        //2진수
        System.out.println(" "+Integer.toBinaryString(binnum));

        String binnum2=Integer.toBinaryString(binnum);
        System.out.printf(" %s%n",binnum2);


        System.out.printf(" boolean: %b %b%n",b,bb);

        System.out.printf(" char : %c%n",c);
        System.out.printf(" char ->int - 유니코드  : %d%n",c1);


        System.out.printf(" byte: %d%n",y);
        System.out.printf(" short: %d%n",s);
        System.out.printf(" int: %d%n",i);

        System.out.printf(" long: %d%n",l);
        System.out.printf(" 8진수 :%#o%n",binnum);
        System.out.printf(" 16진수_소문자 :%#x%n",hexnum);
        System.out.printf(" 16진수_대문자 :%#o%n",hexnum);

        System.out.printf(" float -f :%f%n",f);
        System.out.printf(" float -F :%f%n",ff);

        System.out.printf(" double _ :%f%n",d);
        System.out.printf(" double d :%f%n",dd);
        System.out.printf(" double D :%f%n",ddd);


        System.out.printf(" e표현식_소문자  :%e%n",e1);
        System.out.printf(" e표현식_대문자  :%E%n",e2);

        System.out.printf(" String :%s%n",st);

        System.out.println(" 10.0==10.  "+"0.10 ==.10  "+"10f==10.0f  "+"3.14ef =3140.0f  "+"1e1=10.0");

        //정수형 자리수 변환 출력
        int a=10;
        System.out.println("[00000]");
        System.out.printf("[%5d]%n",a);
        System.out.printf("[%-5d]%n",a);
        System.out.printf("[%05d]%n",a);

        //실수형 자리수 변환 출력
        float dff=9.1234567f;
        double doub=1.234567,doub2=(double)dff;
        System.out.println("doub: "+" "+doub+" "+"dff: "+dff+" "+"doub2:"+doub2);
        System.out.printf("[%14.10f --총 14자리 소수점이하 10자리(double 타입의 경우 빈자리 0으로 채워짐]%n",doub);
        System.out.printf("float =9.1234567f -->2진수로 바뀌어 저장하는데 1.001000111110~~ (반올림하여 23번째 자리값 1증가) 즉 정밀도 때문에 값이 변함 :%20.18f%n",dff);
        System.out.printf("double doub2=(double)dff 로 형변환 해도 값이 같아지지는 않음 : %20.18f%n",doub2);




        //문자열 자리수 변환 출력
        String asd="asdasdasd";
        System.out.println("["+asd+"]");
        System.out.printf("[%20s]%n",asd);
        System.out.printf("[%-20s]%n",asd);
        System.out.printf("[%.5s]%n",asd);

        //입력
        Scanner scanner=new Scanner(System.in);
        String input=scanner.nextLine();
        int intnum=Integer.parseInt(input);

        // 정수형 에서 실수형으로 형 변환 할때는 정확도 때문에 오차가 발생한다.
        int wjdtn=91234567;
        float wjdtn2=(float)wjdtn;
        System.out.println("정수 :"+wjdtn);
        System.out.println("실수  "+wjdtn2);
        System.out.println("정수 =(int)실수: "+(int)wjdtn2);


        //자동 형변환 byte->short or char -> int->long->float->double
        //기존의 값을  최대한 보존 할 수 있는 타입으로 자동 형변환 한다.


        //값의 범위가 작은 타입에서 큰 타입으로 형 변환은 생략 가능


        //명시적 형변환
        char chs=(char)1000;
        System.out.println("명시적 형변환 -- char형 보다 큰 1000 이 저장되지만 의도적으로 사용하기위한방법 "+(chs));


    }
}