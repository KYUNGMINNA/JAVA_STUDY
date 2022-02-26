package java2.chapter06;

class Data13{int x;}
public class ch6_14 {
    public static void main(String[] args) {
        Data13 d=new Data13();
        d.x=10;

        Data13 d2=copy(d);
        System.out.println("d.x :"+d.x);
        System.out.println("d2.x : "+d2.x);

    }
    static Data13 copy(Data13 d){
        Data13 tm=new Data13();
        tm.x=d.x;
        return tm;

    }
}
