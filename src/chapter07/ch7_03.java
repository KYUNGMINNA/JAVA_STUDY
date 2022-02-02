package chapter07;

public class ch7_03 {
    public static void main(String[] args) {
    Deck3 d=new Deck3();
    Card3 c=d.pick(0);
    System.out.println(c);




    d.shuffle();
    c=d.pick(0);
        System.out.println(c);
    }

}
class Deck3{
    final  int CARD_NUM=52;
    Card3 cardArr[] =new Card3[CARD_NUM];

    Deck3(){
        int i=0;

        for (int k=Card3.KIND_MAX;k>0;k--){
            for (int n=0;n<Card3.NUM_MAX;n++)
                cardArr[i++]=new Card3(k,n+1);
        }
    }
    Card3 pick(int index){
        return cardArr[index];
    }
    Card3 pick(){
        int index=(int)(Math.random()*CARD_NUM);
        return pick(index);
    }
    void shuffle(){
        for (int i=0;i<cardArr.length;i++){
            int r=(int)(Math.random()*CARD_NUM);

            Card3 tmp=cardArr[i];
            cardArr[i]=cardArr[r];
            cardArr[r]=tmp;
        }
    }


}
class Card3 {
    static final int KIND_MAX = 4;
    static final int NUM_MAX = 13;

    static final int SPADE = 4;
    static final int DIMAND = 3;
    static final int HEART = 2;
    static final int CLOVER = 1;

    int kind;
    int number;

    Card3() {
        this(SPADE, 1);
    }

    Card3(int kind, int number) {
        this.kind = kind;
        this.number = number;
    }

    public String toString() {
        String[] kinds = {"", "CLOVER", "HEART", "DIAMOND", "SPADE"};
        String numbers = "0123456789XJOK";
        return "kind :" + kinds[this.kind] + ", number :" + numbers.charAt(this.number);
    }
}