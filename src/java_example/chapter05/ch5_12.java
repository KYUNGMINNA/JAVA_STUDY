package java_example.chapter05;

public class ch5_12 {
    public static void main(String[] args) {
        String[] name={"kim","park","yi"};
        for (int i=0;i<name.length;i++) System.out.println("names["+i+"]"+name[i]);

        String tmp=name[2];
        System.out.println("tmp : "+tmp);
        name[0]="yu";

        for (String a : name) System.out.println(a);
    }
}
