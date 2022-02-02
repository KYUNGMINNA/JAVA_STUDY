package chapter06;

class Data{int x;}

public class ch6_09{
    public static void main(String[] args) {
        Data d=new Data();
        d.x=10;
        System.out.println("main() :x="+d.x);

        int s=0;
        for(int i=0;i<100;i++) {


            s = (int) (Math.random() * 9 + 1);
            System.out.println(s);
        }
        change(d.x);
        System.out.println("after chagne(d.x)");
        System.out.println("main() :x="+d.x);
    }
    static void change(int x){
        x=1000;

        System.out.println("change() : x="+x);
    }
}
