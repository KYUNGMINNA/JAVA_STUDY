package java.chapter07;

public class ch7_35 {
    public static void main(String[] args) {

        Outer35 o=new Outer35();
        Outer35.Inner inner=o.new Inner();
        inner.method();
    }
}
class Outer35{
    int value=10;

    class Inner{
        int value=20;
        void  method(){
            int value=30;
            System.out.println("value : "+value);
            System.out.println("this.value :"+this.value);
            System.out.println("Outer.this.value :"+Outer35.this.value);
        }
    }
}