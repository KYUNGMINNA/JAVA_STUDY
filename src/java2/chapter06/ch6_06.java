package java2.chapter06;

class MyMath{


    long add(long a,long b){return a+b;}
    long subtract(long a,long b){return a-b;}
    long multiply(long a,long b){return a*b;}
    double divide(double a,double b){return a/b;}

}
public class ch6_06{
    public static void main(String[] args) {

        MyMath mymath=new MyMath();

        long result=mymath.add(5L,3L);
        long result2=mymath.subtract(5L,3L);
        long result3=mymath.multiply(5L,3L);
        double result4=mymath.divide(5L,3L);

        System.out.println("메서드 호출 결과를 변수에 저장 방식");
        System.out.println("add(5L,3L)="+result);
        System.out.println("subtract(5L,3L)="+result2);
        System.out.println("multiply(5L,3L)="+result3);
        System.out.println("divide(5L,3L)="+result4);

        System.out.println("메서드 호출 결과 바로 출력-- 변수 선언 없이");
        System.out.println("add(5L,3L)="+mymath.add(5L,3L));
        System.out.println("subtract(5L,3L)="+mymath.subtract(5L,3L));
        System.out.println("multiply(5L,3L)="+mymath.multiply(5L,3L));
        System.out.println("divide(5L,3L)="+mymath.divide(5L,3L));



    }

}