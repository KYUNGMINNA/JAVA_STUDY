package java_example.chapter03;

public class ch3_22 {
    public static void main(String[] args) {
        float f=0.1f;
        double d=0.1;
        double d2=(double) f;

        System.out.println(10==10.f);
        System.out.println(0.1==0.1f);
        System.out.printf("%19.17f%n",f);
        System.out.printf("%19.17f%n",d);
        System.out.printf("%19.17f%n",d2);
        System.out.println(d==f);
        System.out.println(d==d2);
        System.out.println((float) d==f);

    }
}
