package java.chapter06;

public class ch6_11 {
    public static void main(String[] args) {
        int[] x={10};
        System.out.println("main() :x ="+x[0]);

        chage(x);
        System.out.println("after chnage(x)");
        System.out.println("main() : x"+x[0]);
    }
    static void chage(int[] x){
        x[0]=1000;
        System.out.println("change() : x"+x[0]);
    }
}
