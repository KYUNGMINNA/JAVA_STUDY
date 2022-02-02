package chapter04;

public class ch4_01 {
    public static void main(String[] args) {
        int x=0;

        System.out.printf("x==%d일때 참인 것은 %n",x);
        System.out.printf("");

        if (x==0)    System.out.println("x==0");
        if (x!=0)    System.out.println("x!=0");
        if (!(x==0)) System.out.println("!(x==0)");
        if (!(x!=0)) System.out.println("!(x!=0)");

        x=1;

        System.out.printf("x==%d일때 참인 것은 %n",x);


        if (x==0)    System.out.println("x==0");
        if (x!=0)    System.out.println("x!=0");
        if (!(x==0)) System.out.println("!(x==0)");
        if (!(x!=0)) System.out.println("!(x!=0)");


    }
}
