package chapter09;

public class ch9_04 {
    public static void main(String[] args) {

        Card c1=new Card();
        Card c2=new Card();

        System.out.println("일반 클래스( String클래스,Data클래스 제외) 들은 tosring() == 클래스이름@객체주소");
        System.out.println(c1.toString());
        System.out.println(c2.toString());
    }

}
class  Card{
    String kind;
    int number;

    Card(){
        this("SPADE",1);
    }
    Card(String kind,int number){
        this.kind=kind;
        this.number=number;
    }
}
