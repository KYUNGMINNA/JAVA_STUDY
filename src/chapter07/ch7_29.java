package chapter07;

public class ch7_29 {
    public static void main(String[] args) {
        A29 a=new A29();
        a.methodA();

    }
}
class A29 {
    void methodA(){
        I29 i=InstanceManager29.getInstance();
        i.methodB();
        System.out.println(i.toString());
    }
}
interface I29{
    public abstract void methodB();
}
class B29 implements I29{
    public void methodB(){
        System.out.println("methodB in B class");
    }
    public String toString(){
        return "class B";
    }
}
class InstanceManager29{
    public static I29 getInstance(){
        return new B29();
    }
}