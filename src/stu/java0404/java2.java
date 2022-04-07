package stu.java0404;

import stu.java0328.java0401.B;

class java2_A{

    static void java2_A_static_method(){
        System.out.println("java2_A_static_method call");
    }

    void java2_A_method(){
        System.out.println("java2_A_method");
    }

    static int v;

    void g(){
        System.out.println(" void g () called");
    }
    final void h(){
        System.out.println("final void h ()called ");
    }
}
class BBB extends java2_A{
    @Override
    void g(){
        System.out.println("class B Override   class java2_A 의 void g( ) ");
    }
}
final class CCC{  //final 클래스서 상속 불가

}
//class DDD extends CCC  ::

public class java2 {
    public static void main(String[] args) {
        java2_A.java2_A_static_method();

        java2_A A1=new java2_A();
        A1.java2_A_method();


        A1.java2_A_static_method();

        System.out.println("----------------------------");
        java2_A.v=123;

        System.out.println("java2_A.v = " + java2_A.v);

        java2_A A2=new java2_A();

        A2.v=456;
        System.out.println("A2.v = " + A2.v);

        java2_A A3=new java2_A();
        java2_A.v=66666666;
        System.out.println("A3.v = " + A3.v);

        System.out.println("===========================");

        BBB bb=new BBB();
        bb.g();

        /////////////////////////////////////
        trycatch tr=new trycatch();
        try{
            tr.exce();
        }catch (Exception e){
            e.printStackTrace();
        }

    }}

class trycatch {
    public void exce() throws Exception{
        throw new Exception();
    }
}