package java0328;
import java0401.B;

public class java2{
  B b=new B( ) ;
  
  b.b_a=3;  -- X
  b.b_b=5;  -- O
  b.b_c=4;  -- X
    
  b.b_methoda(); -- X
  b.b_methodb(); -- O
  b.b_methodc(); -- X
    
    
  B b2=new B(4); -- O 
  
}

package java0401;
public class B{
  int b_a;
  
  public int b_b;
  
  private int b_c;
  
  
  void b_methoda (  ){  }
  
  public void b_methodb ( ) { } 
  
  private void b_methodc( ) { } 
  public B() { } 
  public B(int c) { } 
}
-------------------------

class C {
public int c1;
public void c_method() { } 
} 

Class D  extends C {
  public int d1;
  public void d_method() { }}

}

public class Main{ 
  public static vod main(String[] args){
   D d =new D( );
   
   d.c1=123;     -- OK
   d.c_method(); -- OK
     
   d.d1=456;     -- OK
   d.d_method(); -- OK
  
  }
}

-------
class f { 
   public void f_method( ) { }  
 }

inerface g{
  public void g_method( ) ;
}
