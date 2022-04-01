interface A{

  public void A_method();
}
class B implements A{
  
  @Override
  public void A_method(){
 
    System.out.println("Class B implements A");
  }
}
class C{
  public static void main(String[] args){
    
    B b=new B();
    b.A_method();
    
    
    A a=new B();
    a.A_method();
  
  
  }

}
