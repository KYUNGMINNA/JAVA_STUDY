public class 1weeks{ 
  public static void main(String[] args){
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
    
    
    int[] arrays=new int[3];
    methodtest me=new methodtest();
    
    me.methodtestcall(1,2);
    me.stringmethodtest("집에 가고싶다");
    me.floatmethodtest("1.23f");
    me.arraymethodtest(arrays);
  }
  
}
class test{ 
  int aa;
}
class methodtest{
   public int methodtestcall(int a,int b){
     return a+b;
   
   }
  public String stringemthodtest(String str){
    return str; 
  }
  public float floatmethodtest(float flo){
    return flo;
  
  }
  public int[] arraymethodtest(int[] arrs){
    return arrs;
    
  
  }

}
