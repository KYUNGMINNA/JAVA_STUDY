package stu.java0328;

import stu.java0328.java0401.B;

public class javas {
    public static void main(String[] args) {


        B b = new B();

        b.b_a = 3;
        //--X
        b.b_b = 5;
        //--O
        b.b_c = 4;
        //--X

        b.b_method();
        //--X
        b.b_methodb();
        //--O
        b.b_methodc();
        //--X


        B b2 = new B(4);
        //--O

    }
}



class C {
    public int c1;

    public void c_method() {

    }
}

class D  extends C {
  public int d1;
  public void d_method() { }}


class Main{
  public static void main(String[] args){
   D d =new D( );
   
   d.c1=123;     //-- OK
   d.c_method(); //-- OK
     
   d.d1=456;     //-- OK
   d.d_method(); //-- OK
  
  }
}
