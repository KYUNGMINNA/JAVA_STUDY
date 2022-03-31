package java0328;
import java0401.B;

public class java2{
  B b=new B( ) ;
  
  b.b_a=3;  -- X
  b.b_b=5;  -- O

  b.b_methoda(); -- X
  b.b_methodb(); -- O

  B b2=new B(4); -- O 
  
}

package java0401;
public class B{
  int b_a;
  
  public int b_b;
  
  void b_methoda (  ){  }
  
  public void b_methodb ( ) { } 
  
  public B() { } 
  public B(int c) { } 
}
