//0321--
class Car{
  int oil=0;
  void fill_oil(int oil){
  this.oil=oil;
  }
  
  
  
}
class Main{
  public static void main(String[] args){
    //--0321
    Car car=new Car();
    System.out.println(car.fill_oil(300));
    System.out.println(car.oil);
    //--0321
    
    output outs=new output();
    System.out.println(outs);
    System.out.println(outs.sub_output=new output());
    
    
    
  }
  
  
  
 //--0321
class Secondcar{
  Car[] arraycar;
  
  void init(){
    arraycar=new Car[4];
    
    arraycar[0]=new Car();
    arraycar[1]=new Car();
    arraycar[2]=new Car();
    arraycar[3]=new Car();
      }
  }
  
  //0322
  class output{
    output sub_output;
    
    output returnoutput(){
      return new output();
    }
    
    output returnoutput2(){
     sub_output=new output();
      return sub_output;
    }
    
    
  }
