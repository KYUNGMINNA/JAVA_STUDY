package chapter07;

import java.util.*;
public class ch7_23 {
    public static void main(String[] args) {
        Buyer23 b=new Buyer23();
        TV23 tv=new TV23();
        Computer23 com=new Computer23();
        Audio23 aud=new Audio23();

        b.buy(tv);
        b.buy(com);
        b.buy(aud);
        b.summary();
        System.out.println();
        b.refund(com);
        b.summary();


    }
}class Product23{
    int price;
    int bonusPoint;

    Product23(int price){
        this.price=price;
        bonusPoint=(int)(price/10.0);

    }
    Product23(){
        price=0;
        bonusPoint=0;
    }
}
class TV23 extends Product23{
    TV23(){
        super(100);
    }
    public String toString(){
        return "TV";
    }
}
class Computer23 extends Product23{
    Computer23(){
        super(200);
    }
    public String toString(){
        return "Computer";
    }
}
class Audio23 extends Product23{
    Audio23(){
        super(50);
    }
    public String toString(){
        return "Audio";
    }
}
class Buyer23{
    int money=1000;
    int bounsPoint=0;
    Vector item=new Vector();

    void buy(Product23 p){
        if (money<p.price){
            System.out.println("잔익애 부족하여 구매할 수 없습니다.");
             return;
        }
        money-=p.price;
        bounsPoint+=p.bonusPoint;
        item.add(p);
        System.out.println(p+"을/를 을 구입하셨습니다.");
    }
    void refund(Product23 p){
        if (item.remove(p)){
            money+=p.price;
            bounsPoint-=p.bonusPoint;
            System.out.println(p+"을/를 을 환불 하셨습니다.");
        }else{
            System.out.println("구입하신 제품 중 해당 제품이 없습니다");
        }
    }

    void summary(){
        int sum=0;
        String itemList=" ";

        if (item.isEmpty()){
            System.out.println("구입하신 제품이 없습니다.");
            return;
        }



        for (int i=0;i<item.size();i++)
        {
            Product23 p =(Product23)item.get(i);
            sum+=p.price;
            itemList+=(i==0 )? ""+p :","+p;

        }
        System.out.println("구입하신 제품의 가격은 "+sum);
        System.out.println("구입한 물품의 목록은 :"+itemList);
    }





}