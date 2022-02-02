package chapter07;

public class ch7_33 {
    private int outerIv=0;
    static  int outerCv=0;
    class InstanceInner33{
        int iiv=outerIv;
        int iiv2=outerCv;
    }
    static class StaticInner{
        static  int scv=outerCv;
    }

    void myMethod(){
        int lv=0;
        final int LV=0;
        class LocalInner33{
            int liv=outerIv;
            int liv2=outerCv;
            int liv4=LV;
        }
    }
    public static void main(String[] args) {


    }
}
