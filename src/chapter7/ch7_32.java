package chapter7;


public class ch7_32 {
    public static void main(String[] args) {


    }
    class InstanceInner32{}
    static class StaticInner32{}

    InstanceInner32 iv=new InstanceInner32();
    static StaticInner32 cv=new StaticInner32();

    static void staticMethod(){
        StaticInner32 obj2=new StaticInner32();

        ch7_32 outer=new ch7_32();
        InstanceInner32 obj1=outer.new InstanceInner32();

    }
    void instaceMethod(){
        InstanceInner32 obj1=new InstanceInner32();
        StaticInner32 obj2=new StaticInner32();

    }
    void myMethod(){
        class LocalInner32{}
        LocalInner32 lv=new LocalInner32();
    }
}
