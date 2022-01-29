package chapter7;

public class ch7_19 {
    public static void main(String[] args) {

        Parent19 p=new Child19();
        Child19 c=new Child19();

        System.out.println("p.x :"+p.x);

        p.method();
        System.out.println("c.x :"+c.x);
        c.method();
    }
}
class  Parent19{
    int x=100;
    void method(){
        System.out.println("Parent Method");
    }
}
class  Child19 extends Parent19{}
