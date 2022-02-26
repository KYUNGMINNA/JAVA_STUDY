package java2.chapter07;

public class ch7_12 {
    public static void main(String[] args){
        Card12 c=new Card12("HEART",10);
        System.out.println(c.KIND);
        System.out.println(c.NUMBER);
        System.out.println(c);
    }
}
class Card12{
    final int NUMBER;
    final String KIND;
    static int width=100;
    static int height=250;

    Card12(String kind,int num){
        KIND=kind;
        NUMBER=num;
    }
    Card12(){
        this("HEART",1);
    }
    public String toString(){
        return KIND+" "+NUMBER;
    }
}
