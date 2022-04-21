package stu.java0404_java0408;


class A{
    void g(){
        System.out.println("class A  void g () ");
    }

}
class B extends  A{
    @Override
    void g(){
        System.out.println("class B extends A void g () ");
    }
    void g(String s){
        System.out.println(s);
    }
}

abstract class C{
    abstract void h();
    
}
class D extends C{
    @Override
    public void h(){
        System.out.println("class D extends C :: abstract class C : abstract void h()완성");
    }
}
interface G{
    public abstract void z();
}interface H{
    public abstract void z();
}
class K implements G{
    @Override
    public void z(){
        System.out.println("class K implents G의 void z( ) ");
    }
}
public class java3 {
    public static void main(String[] args) {

        A a=new A();
        a.g();
        
        
        B b=new B();
        b.g("asd");
        b.g();

        C c=new D();
        c.h();

    }
}
