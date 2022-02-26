package java_example.chapter07;

public class ch7_31 {
    class InstanceInner31{
        int iv=100;
        final static int CONST=100;


    }
    static class StaticInner31{
        int iv=200;
        static int cv=200;

    }
    void myMethod(){
        class LocalInner31{
            int iv=300;
            final static  int CONST=300;
        }
    }
    public static void main(String[] args) {
        System.out.println(InstanceInner31.CONST);
        System.out.println(StaticInner31.cv);
    }
}

