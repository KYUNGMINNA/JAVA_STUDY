interface A{

  public void A_method();
}
class B implements A{
  
  @Override
  public void A_method(){
 
    System.out.println("Class B implements A");
  }
}
class C implements A{
  @Override
  public void A_method() {
    
    System.out.println("Class C implements A");
  }
}
class D{
  public static void main(String[] args){
    
    B b=new B();
    b.A_method();
    
    C c=new C();
    c.A_method();
    
    A a=new B();
    a.A_method();
    
    ///////////////////////////
    
    A aa;
   
    aa=b;
    aa.A_method();
    
    aa=c;
    aa.A_method();
  
  //////////  ::static A new_met( ) { } 
    A aaa;
    aaa=new_met();
    aaa.a_method();
  }
  static A new_met()
  {
    return new B;
    //return new B;
  }
}
