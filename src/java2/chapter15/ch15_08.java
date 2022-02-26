package java2.chapter15;

import java.io.*;

public class ch15_08 {
    public static void main(String[] args){
        FileOutputStream fos=null;
        DataOutputStream dos=null;

        try{
            fos=new FileOutputStream("ch15_08_sample.dat");
            dos=new DataOutputStream(fos);
            dos.writeInt(10);
            dos.writeFloat(20.0f);
            dos.writeBoolean(true);

            dos.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
