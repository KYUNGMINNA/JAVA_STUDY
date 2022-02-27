package java_example.Data_structure;

import java.util.Arrays;

public class Bubblesort_array {
    public static void main(String[] args) {
        int[] bubblesort=new int[10];

        for (int i=0;i<bubblesort.length;i++)
            bubblesort[i]=(int)(Math.random()*100+1);

        System.out.println("Sorting before : "+Arrays.toString(bubblesort));

        for (int i=0;i<bubblesort.length-1;i++){
            for (int j=0;j<bubblesort.length-1-i;j++){
                if (bubblesort[j]>bubblesort[j+1]){
                    int temp=bubblesort[j];
                    bubblesort[j]=bubblesort[j+1];
                    bubblesort[j+1]=temp;
                }
            }
        }

        System.out.println("Sorting after : "+Arrays.toString(bubblesort));
    }
}
