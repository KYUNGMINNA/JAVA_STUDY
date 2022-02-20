package java.chapter09;

public class ch9_10 {
    public static void main(String[] args) throws  Exception{

        Card10 c=new Card10("HEART",2);
        Card10 c2=Card10.class.newInstance();

        Class cObj=c.getClass();

        System.out.println(c);
        System.out.println(c2);
        System.out.println(cObj.getName());
        System.out.println(cObj.toGenericString());
        System.out.println(cObj.toString());

    }

}
final class Card10{
    String kind;
    int number;

    Card10(){
        this("SPACE",1);
    }
    Card10(String kind,int number){
        this.kind=kind;
        this.number=number;
    }
    public String toString(){
        return kind+" :"+number;
    }
}