package chapter05;

public class ch5_11 {
    public static void main(String[] args) {
        int[] numarr=new int[10];
        int[] counter=new int[10];

        for (int i=0;i<numarr.length;i++){
            numarr[i]=(int) (Math.random()*10);
            System.out.print(numarr[i]);
        }
        System.out.println();

        for (int i=0;i<numarr.length;i++) counter[numarr[i]]++;

        for (int i=0;i<numarr.length;i++) System.out.println(i+"의 개수 :"+counter[i]);

    }
}
