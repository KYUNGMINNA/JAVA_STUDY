package chapter15;

import java.io.*;

public class ch15_11 {
    public static void main(String[] args){
        int[] score={100,90,95,85,50};

        try{
            FileOutputStream fos=new FileOutputStream("ch15_11_score.dat");
            DataOutputStream dos=new DataOutputStream(fos);

            for (int i=0;i< score.length;i++){
                dos.writeInt(score[i]);
            }
            dos.close();
        }catch (IOException e){
            e.printStackTrace();;
        }
    }
}
