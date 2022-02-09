package chapter12;

import java.util.ArrayList;

public class ch12_02 {
    public static void main(String[] args) {

        FruitBox2<Fruit2> fruitBox = new FruitBox2<Fruit2>();
        FruitBox2<Apple2> appleBox = new FruitBox2<Apple2>();
        FruitBox2<Grape2> grapeBox = new FruitBox2<Grape2>();

        fruitBox.add(new Fruit2());
        fruitBox.add(new Apple2());
        fruitBox.add(new Grape2());

        appleBox.add(new Apple2());
        grapeBox.add(new Grape2());

        System.out.println("fruitBox-"+fruitBox);
        System.out.println("appleBox-"+appleBox);
        System.out.println("grapeBox-"+grapeBox);

    }

}
class Fruit2 implements Eatable {
    public String toString() { return "Fruit";}
}
class Apple2 extends Fruit2 { public String toString() { return "Apple";}}
class Grape2 extends Fruit2 { public String toString() { return "Grape";}}
class Toy2		          { public String toString() { return "Toy"  ;}}

interface Eatable {}
class FruitBox2<T extends Fruit2 & Eatable> extends Box2<T> {}

class Box2<T> {
    ArrayList<T> list = new ArrayList<T>();
    void add(T item)  { list.add(item);      }
    T get(int i)      { return list.get(i); }
    int size()        { return list.size();  }
    public String toString() { return list.toString();}
}