package java2.chapter15;

import java.io.*;

public class ch15_27 {
    public static void main(String[] args) {
        int sum=0;

        try {
            RandomAccessFile raf=new RandomAccessFile("score2.dat","r");
            int i=4;

            while(true){
                raf.seek(i);
                sum+=raf.readInt();
                i+=16;
            }
        }catch (EOFException eof){
            System.out.println("sum : "+sum);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
