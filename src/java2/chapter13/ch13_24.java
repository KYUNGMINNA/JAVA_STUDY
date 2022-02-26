package java2.chapter13;

import java.util.*;

public class ch13_24 {
    public static void main(String[] args) throws Exception{
        Table24 table = new Table24();

        new Thread(new Cook24(table), "COOK1").start();
        new Thread(new Customer24(table, "donut"),  "CUST1").start();
        new Thread(new Customer24(table, "burger"), "CUST2").start();

        Thread.sleep(5000);
        System.exit(0);
    }

}
class Customer24 implements Runnable{
    private Table24 table24;
    private String food24;
    Customer24(Table24 table24,String food24){
        this.table24=table24;
        this.food24=food24;
    }
    public void run() {
        while(true) {
            try { Thread.sleep(10);} catch(InterruptedException e) {}
            String name = Thread.currentThread().getName();

            if(eatFood())
                System.out.println(name + " ate a " + food24);
            else
                System.out.println(name + " failed to eat. :(");
        }
    }

    boolean eatFood() { return table24.remove(food24); }

}
class Cook24 implements Runnable {
    private Table24 table24;

    Cook24(Table24 table24) {	this.table24 = table24; }

    public void run() {
        while(true) {
            int idx = (int)(Math.random()*table24.dishNum());
            table24.add(table24.dishNames[idx]);
            try { Thread.sleep(100);} catch(InterruptedException e) {}
        }
    }
}
class Table24 {
    String[] dishNames = { "donut","donut","burger" };
    final int MAX_FOOD = 6;
    private ArrayList<String> dishes = new ArrayList<>();

    public synchronized void add(String dish) {
        if(dishes.size() >= MAX_FOOD)
            return;
        dishes.add(dish);
        System.out.println("Dishes:" + dishes.toString());
    }

    public boolean remove(String dishName) {
        synchronized(this) {
            while(dishes.size()==0) {
                String name = Thread.currentThread().getName();
                System.out.println(name+" is waiting.");
                try { Thread.sleep(500);} catch(InterruptedException e) {}
            }

            for(int i=0; i<dishes.size();i++)
                if(dishName.equals(dishes.get(i))) {
                    dishes.remove(i);
                    return true;
                }
        }

        return false;
    }

    public int dishNum() { return dishNames.length; }
}