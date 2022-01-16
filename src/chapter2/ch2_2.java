package chapter2;

public class ch2_2 {
    public static void main(String[] args) {
        int x=10,y=20;
        int tmp=0;

        System.out.println("x :"+x+" y:"+y);

        System.out.println("x,y change");
        tmp=x;
        x=y;
        y=tmp;
        System.out.println("x :"+x+" y:"+y);
    }
}
