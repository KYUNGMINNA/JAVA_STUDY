package java_example.chapter09;

public class ch9_06 {
    public static void main(String[] args) {
        Card_2 card=new Card_2();
        Card_2 card1=new Card_2("HEART",10);

        System.out.println("card = "+card.toString());

        System.out.println("card1 = "+card1.toString());

    }

}
class Card_2{
    String kind;
    int number;

    Card_2(){
        this("SPADE",1);
    }
    Card_2(String kind,int number){
        this.kind=kind;
        this.number=number;
    }
    public String toString(){
        return "kind :"+kind+"     number :"+number;
    }
}
