package java_example.chapter06;

public class ch6_21 {
    public static void main(String[] args) {
    MyMath3 my=new MyMath3();

        System.out.println("my.add(3,3) 결과 : "+my.add(3,3));
        System.out.println("my.add(3,3L) 결과 :"+my.add(3,3L));
        System.out.println("my.add(3L,3) 결과 :"+my.add(3L,3));
        System.out.println("my.add(3L,3L) 결과 :"+my.add(3L,3L));
        int[] a={100,200,300};
        System.out.println("my.add(a) 결과  :"+my.add(a));


    }

}
class MyMath3{
    int add(int a, int b){
        System.out.print("int add(int a, int b) - ");
        return a+b;
    }
    long add(int a,long b){
        System.out.print("long add (int a, long b) -");
        return a+b;
    }
    long add(long a, int b){
        System.out.print("long add (long a, int b) -");
        return a+b;
    }
    long add(long a, long b){
        System.out.print("long add(long a, long b) - ");
        return a+b;
    }
    int add(int[] a){
        System.out.print("int add(int[] a) -");
        int result=0;
        for (int i=0;i<a.length;i++) result+=a[i];

        return result;
    }
}