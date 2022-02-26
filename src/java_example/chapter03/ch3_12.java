package java_example.chapter03;

public class ch3_12 {
    public static void main(String[] args) {
        char c1='a';
        char c2=c1;
        char c3=' ';

        System.out.println("(int)c1="+(int)c1);
        System.out.println("(int)c2="+(int)c2);
        System.out.println("(int)c3="+(int)c3);

        int i=c1+1;
        c3=(char)(c1+1);
        c2++;
        c2++;

        System.out.println("i="+i);
        System.out.println("c2="+c2+" (int)c2="+(int)c2);
        System.out.println("c3="+c3+" (int)c3="+(int)c3);
    }
}
