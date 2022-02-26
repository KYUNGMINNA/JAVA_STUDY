package java_example.chapter06;

class Data2{int x;}

public class ch6_10 {
    public static void main(String[] args) {
        Data2 d2=new Data2();

        d2.x=10;
        System.out.println("main() : x="+d2.x);

        change(d2);
        System.out.println("after change(d2)");
        System.out.println("main() :x="+d2.x);


    }
    static void change(Data2 d2){
        d2.x=1000;
        System.out.println("change() : x="+d2.x);
    }
}
