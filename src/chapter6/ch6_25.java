package chapter6;


public class ch6_25 {
    public static void main(String[] args) {
    car12 c1=new car12();
    car12 c2=new car12("blue");

        System.out.println("c1 = "+c1.color+ " :"  + c1.gear +" :  " + c1.door);
        System.out.println("c2 = "+c2.color+ " :"  + c2.gear +" :  " + c2.door);



    }
}
class car12{
    String color;
    String gear;
    int door;

    car12(){
        this("white","auto",4);
    }
    car12(String color){
        this(color,"auto",4);
    }
    car12(String color,String gear,int door){
        this.color=color;
        this.gear=gear;
        this.door=door;
    }
}