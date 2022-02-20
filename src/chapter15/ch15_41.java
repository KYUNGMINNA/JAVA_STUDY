package chapter15;

import java.io.*;
import java.util.ArrayList;

public class ch15_41 {
    public static void main(String[] args) {
        try
        {


        String fileName = "UseroInfo.ser";
        FileInputStream fis = new FileInputStream(fileName);
        BufferedInputStream bis = new BufferedInputStream(fis);

        ObjectInputStream in = new ObjectInputStream(bis);

        ch15_39 u1 = (ch15_39) in.readObject();
        ch15_39 u2 = (ch15_39) in.readObject();
        ArrayList list = (ArrayList) in.readObject();

        System.out.println(u1);
        System.out.println(u2);
        System.out.println(list);
        in.close();
    }catch (Exception e){
            e.printStackTrace();
        }
    }

}
