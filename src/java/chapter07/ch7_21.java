package java.chapter07;

public class ch7_21 {
    public static void main(String[] args) {
        Buyer21 b=new Buyer21();

        b.buy(new TV21());
        b.buy(new Computer21());


        System.out.println("현재 남은 돈 : "+b.money);
        System.out.println("현재 포인트 :"+b.bonusPoint);

    }
}
class Product21{
    int price;
    int bonusPoint;

    Product21(int price){
        this.price=price;
        bonusPoint=(int)(price/10.0);

    }
}
class TV21 extends Product21{
    TV21(){
        super(100);
    }
    public String toString(){
        return "TV";
    }
}
class Computer21 extends Product21{
    Computer21(){
        super(200);
    }
    public String toString(){
        return "Computer";
    }
}
class Buyer21{
    int money=1000;
    int bonusPoint=0;

    void buy(Product21 p){
        if (money<p.price){
            System.out.println("잔액이 부족하여 구매할 수 없습니다.");
            return;
        }

        money-=p.price;
        bonusPoint+=p.bonusPoint;
        System.out.println(p+"을/를 구매 하였습니다.");


    }
}