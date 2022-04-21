package stu.java0404_java0408;

public class java {
    public static void main(String[] args) {

        System.out.println(mehtod_B());
    }
    static int method_A(){
        int a=1;
        while(a<10){
            a+=a;
        }
        return a;
    }

    static int mehtod_B(){
        int d=0;
        int b=3;
        while(b<540){
            int c=method_A();
            b+=c;
        }
        return b;
    }
}
