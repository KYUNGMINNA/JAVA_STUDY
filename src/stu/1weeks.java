public class 1weeks{ 
  public static void main(String[] args){
    
    // 03.18-
    int a;
    int[] b;
    
    test t;
    test[] te;
    
    b=new int[2];
    b[0]=123;
    b[1]=456;
    
    
    
    t=new t();
    t.aa=1234567;
    
    
    te=new test[2];
   
    te[0]=new t();
    te[1]=new t();
    
    te[0].aa=1;
    te[1].aa=2;
    //-03.18
    
    
    //03.19
    methodtest me=new methodtest();
    
    me.plus_method(1,2);
    
    me.stringemthod("String message");
    
    me.float_method("1.23f");
    
    
    me.void_method();
    //-03.19
  }
  
}
//03.18
class test{ 
  int aa;
}//-03.18


//03.19
class methodtest{
  
   public int plus_method(int a,int b){
     return a+b;
   }
  
  public String string_method(String str){
    return str; 
  }
  public float float_method(float flo){
    return flo;
  
  }
  public void void_method() {
    System.out.println("return void method ");
  }
  methodtest tes(){
    return new methodtest();
  }
  methodtest2 tes2(){
    
    return new methodtest2();
  }
}
class methodtest2{

}
//-03.19
