package stu.java0328;


//0401--
interface AA{

  public void A_method();
}
class B implements AA {

  @Override
  public void A_method(){

    System.out.println("Class B implements A");
  }
}
class CC implements AA{
  @Override
  public void A_method() {

    System.out.println("Class C implements A");
  }
}
class DD{
  public static void main(String[] args){

    B b=new B();
    b.A_method();

    CC c=new CC();
    c.A_method();

    AA a=new B();
    a.A_method();

    ///////////////////////////

    AA aa;

    aa=b;
    aa.A_method();

    aa=c;
    aa.A_method();

  //////////  ::static A new_met( ) { }

      DD.new_met();
  }
  static B new_met()
  {
    return new B();
    //return new B;
  }
}


//--0401
