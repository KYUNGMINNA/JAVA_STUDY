package chapter07;

public class ch7_34 {
    public static void main(String[] args) {

        Outer34 oc=new Outer34();
        Outer34.InstanceInner34 li=oc.new InstanceInner34();

        System.out.println("li.iv : "+li.iv);
        System.out.println("Outer.StaticInner.cv : "+Outer34.StaticInner34.cv);

        Outer34.StaticInner34 si=new Outer34.StaticInner34();
        System.out.println("si.iv : "+si.iv);

    }
}
class  Outer34{
    class InstanceInner34{
        int iv=200;

    }
    static class StaticInner34{
        int iv=200;
        static int cv=300;
    }
    void myMethod(){
        class LocalInner34{
            int iv=400;
        }
    }
}

