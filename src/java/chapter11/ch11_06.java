package java.chapter11;

import java.util.*;

public class ch11_06 {
    public static void main(String[] args) {

        ArrayList al=new ArrayList(1000000);
        LinkedList li=new LinkedList();
        add(al);
        add(li);


        System.out.println(access(al));
        System.out.println(access(li));
    }
    public static void add(List list){
        for (int i=0;i<10000;i++) list.add(i+"");
    }
    public static long access(List list){
        long start=System.currentTimeMillis();
        for (int i=0;i<10000;i++) list.get(i);
        long end=System.currentTimeMillis();
        return end-start;
    }
}
