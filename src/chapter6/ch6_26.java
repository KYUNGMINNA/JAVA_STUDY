package chapter6;

public class ch6_26 {
    public static void main(String[] args) {
    Car26 c1=new Car26();
    Car26 c2=new Car26(c1);

    System.out.println("c1 = "+c1.color+ " :"  + c1.gear +" :  " + c1.door);
    System.out.println("c2 = "+c2.color+ " :"  + c2.gear +" :  " + c2.door);

    c1.color="black";
    c1.gear="stick";
    c1.door=2;
        System.out.println("c1  member value chage ");
    System.out.println("c1 = "+c1.color+ " :"  + c1.gear +" :  " + c1.door);
    System.out.println("c2 = "+c2.color+ " :"  + c2.gear +" :  " + c2.door);



    }
}
class Car26{
    String color;
    String gear;
    int door;

    Car26(){
        this("white","auto",4);
    }
    Car26(Car26 c){
        color=c.color;
        gear=c.gear;
        door=c.door;
        }



        Car26(String color,String gear,int door){
        this.color=color;
        this.gear=gear;
        this.door=door;
    }
}
