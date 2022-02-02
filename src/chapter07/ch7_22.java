package chapter07;

public class ch7_22 {
    public static void main(String[] args) {
    Buyer22 b=new Buyer22();
    b.buy(new TV22());
    b.buy(new Computer22());
    b.buy(new Audio22());
    b.summary();


    }
}
class Product22{
    int price;
    int bonusPoint;

    Product22(int price){
        this.price=price;
        bonusPoint=(int)(price/10.0);

    }
}
class TV22 extends Product22{
    TV22(){
        super(100);
    }
    public String toString(){
        return "TV";
    }
}
class Computer22 extends Product22{
    Computer22(){
        super(200);
    }
    public String toString(){
        return "Computer";
    }
}
class Audio22 extends Product22{
    Audio22(){
        super(50);
    }
    public String toString(){
        return "Audio";
    }
}
class Buyer22{
    int money=1000;
    int bonusPoint=0;
    Product22[] item=new Product22[10];
    int i=0;

    void buy(Product22 p){
        if (money<p.price){
            System.out.println("잔액이 부족하여 구매할 수 없습니다.");
            return;
        }

        money-=p.price;
        bonusPoint+=p.bonusPoint;
        item[i++]=p;
        System.out.println(p+"을/를 구매 하였습니다.");


    }
    void summary(){
        int sum=0;
        String itemList=" ";

        for (int i=0;i<item.length;i++){
            if (item[i]==null) break;
            sum +=item[i].price;
            itemList+=item[i]+",";

        }
        System.out.println("구입하신 물품의 총 금액은 :"+sum);
        System.out.println("구입하신 물건의 목록은 :"+itemList);
    }
}