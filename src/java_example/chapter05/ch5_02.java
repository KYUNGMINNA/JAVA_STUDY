package java_example.chapter05;

import java.util.*;
public class ch5_02 {
    public static void main(String[] args) {

        int[] iaar1=new int[10];
        int[] iaar2=new int[10];
        //int[] iaar3=new int[]{100,90,80,70,60};
        int[] iaar3={100,90,80,70,60};
        char[] chharr={'a','b','c','d'};

        for (int i=0;i<iaar1.length;i++) iaar1[i]=i+1;
        for (int i=0;i< iaar2.length;i++) iaar2[i]=(int)(Math.random()*10)+1;
        for (int i=0;i< iaar1.length;i++) System.out.println(iaar1[i]+",");

        System.out.println();
        System.out.println(Arrays.toString(iaar2));
        System.out.println(Arrays.toString(iaar3));
        System.out.println(Arrays.toString(chharr));
        System.out.println(iaar3);
        System.out.println(chharr);
    }


}
