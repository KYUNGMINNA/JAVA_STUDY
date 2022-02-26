package java_example.chapter06;

class Card{
    String kind;
    int number;

    static int width;
    static int height;
}
public class ch6_05{
    public static void main(String[] args) {

        System.out.println("공통 속성(클래스 변수)인 카드의 가로의 길이는"+Card.width);
        System.out.println("공통 속성(클래스 변수)인 카드의 세로의 길이는"+Card.height);

        Card c1=new Card();
        Card c2=new Card();


        c1.kind="heart";
        c1.number=5;

        c2.kind="spade";
        c2.number=7;

        System.out.println("c1의 카드의 종류 "+c1.kind+" c1의 카드의 숫자 번호"+c1.number+" 입니다"+" c1의 카드 크기 가로 세로 는 "+c1.width+"  "+c1.height);
        System.out.println("c2의 카드의 종류 "+c2.kind+" c2의 카드의 숫자 번호"+c2.number+" 입니다"+" c2의 카드 크기 가로 세로 는 "+c2.width+"  "+c2.height);

        System.out.println("c1의 카드의 크기를 50 70으로 변경합니다.");
        c1.width=50;
        c1.height=70;

        System.out.println("바뀐 c1의 카드 크기는"+c1.width+"  "+c1.height);
        System.out.println("c2의 카드 크기는"+c2.width+" "+c2.height);



    }
}
