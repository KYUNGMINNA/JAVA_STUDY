package java_study;

public class chapter3_operator {
    public static void main(String[] args) {

        int a=10,b=3;

        //산술 연산자
        System.out.println("산술 연산자");
        System.out.println("a: "+a+" "+"b: "+b);
        System.out.println("a+b "+(a+b));
        System.out.println("a-b "+(a-b));
        System.out.println("a*b "+(a*b));
        System.out.println("a/b "+(a/b));
        System.out.println("a%b "+(a%b));
        System.out.println("a<<b "+(a<<b));
        System.out.println("a>>b "+(a>>b));

        //비교 연산자
        System.out.println("비교 연산자");
        System.out.println("a: "+a+" "+"b: "+b);
        System.out.println("a>b "+(a>b));
        System.out.println("a<b "+(a<b));
        System.out.println("a>=b "+(a>=b));
        System.out.println("a<=b "+(a<=b));
        System.out.println("a==b "+(a==b));
        System.out.println("a!=b "+(a!=b));

        //문자열 비교
        System.out.println("문자열 비교 ");
        String monja="asd";
        boolean as=monja.equals("asd");
        System.out.println(as);
        System.out.println(!as);


        //논리 연산자
        System.out.println("논리 연산자");
        System.out.println("  x     y     &&     ||");
        System.out.println(" true  true  true   true ");
        System.out.println(" true  false false  true ");
        System.out.println(" false true  false  true ");
        System.out.println(" false false true   false ");

        //논리 비트 연산자
        System.out.println("논리 비트 연산자");
        System.out.println(" & --AND | --OR  ^--XOR  ");
        System.out.println("1|1 ="+(1|1)+" 1&1 ="+(1&1)+" 1^1 ="+(1^1));
        System.out.println("1|0 ="+(1|0)+" 1&0 ="+(1&0)+" 1^0 ="+(1^0));
        System.out.println("0|1 ="+(0|1)+" 0&1 ="+(0&1)+" 0^1 ="+(0^1));
        System.out.println("0|0 ="+(0|0)+" 0&0 ="+(0&0)+" 0^0 ="+(0^0));

        //단항 연산자
        System.out.println("후위형 -- 참조 후 증가");
        System.out.println(" a=10 a++ "+(a++));
        System.out.println(" a=10 a-- "+(a--));
        System.out.println("전위형 -- 참조 전 증가");
        System.out.println(" a=10 ++a "+(++a));
        System.out.println(" a=10 --a "+(--a));

        //삼항 연산자
        System.out.println("a=10 b=3  a>b?a:b  "+((a>b)?a:b));


    }
}
