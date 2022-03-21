//0321--
class Car{
  int oil=0;
  void fill_oil(int oil){
  this.oil=oil;
  }
  
  
  
}
class Main{
  public static void main(String[] args){
    Car car=new Car();
    System.out.println(car.fill_oil(300));
    System.out.println(car.oil);
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
