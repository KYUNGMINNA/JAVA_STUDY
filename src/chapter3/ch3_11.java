package chapter3;

public class ch3_11 {
    public static void main(String[] args) {
        char a='a';
        char d='d';
        char zero='0';  //정수 0 ==유니코드 48
        char two='2'; //정수 2  ==유니코드 50

        System.out.printf("'%c' - '%c'=%d%n",d,a,d-a);
        System.out.printf("문자간 연산은 유니코드로 계산'%c'-'%c'=%d%n",two,zero,two-zero);
        System.out.printf("'%c'=%d%n",a,(int)a);
        System.out.printf("'%c'=%d%n",d,(int)d);
        System.out.printf("'%c'=%d%n",d,(int)zero);
        System.out.printf("'%c'=%d%n",d,(int)two);


    }
}
