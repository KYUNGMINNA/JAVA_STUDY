package chapter06;

class MyMath2{
    long a,b;

    long add(){return a+b;}
    long minus(){return  a-b;}
    long multiply(){return  a*b;}
    double divide(){return  a/b;}


    static long add(long a,long b){return a+b;}
    static long minus(long a,long b){return  a-b;}
    static long multiply(long a,long b){return  a*b;}
    static double divide(double a,double b){return  a/b;}


}
public class ch6_19 {
    public static void main(String[] args) {
        System.out.println(MyMath2.add(200L,100L));
        System.out.println(MyMath2.minus(200L,100L));
        System.out.println(MyMath2.multiply(200L,100L));
        System.out.println(MyMath2.divide(200.0,100.0));

        MyMath2 m=new MyMath2();

        System.out.println(m.add(200L,100L));
        System.out.println(m.minus(200L,100L));
        System.out.println(m.multiply(200L,100L));
        System.out.println(m.divide(200.0,100.0));




    }
}
