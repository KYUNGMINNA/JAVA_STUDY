package java.Data_structure;

import java.util.ArrayList;

public class Array_ArrayList {
    public static void main(String[] args) {
        ArrayList array=new ArrayList(500);
        ArrayList array2=new ArrayList();
        

        array.add(1);
        array.add(3);
        array.add(2);
        System.out.println("1->3->2");
        System.out.println("add() : "+array);
        System.out.print("add(2,20)");
        array.add(2,20);
        System.out.println(array);

        System.out.println("remove :"+array.remove(array.size()-1));


        System.out.println("empty : "+array.isEmpty());

        System.out.println("contains(1) :"+array.contains(1));
        System.out.println("indexOf(1) :"+array.indexOf(1));
    }
}
