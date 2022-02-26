package java_example.chapter15;

import java.io.*;
import java.util.ArrayList;

public class ch15_40 {
    public static void main(String[] args) {
        try{
            String fileName="UseroInfo.ser";
            FileOutputStream fos=new FileOutputStream(fileName);
            BufferedOutputStream bos=new BufferedOutputStream(fos);

            ObjectOutputStream out=new ObjectOutputStream(bos);

            ch15_39 u1=new ch15_39("javaman","1234",30);
            ch15_39 u2=new ch15_39("javawoman","4321",26);

            ArrayList<ch15_39> list=new ArrayList<>();
            list.add(u1);
            list.add(u2);

            out.writeObject(u1);
            out.writeObject(u2);
            out.writeObject(list);
            out.close();
            System.out.println("직렬화 완료");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
