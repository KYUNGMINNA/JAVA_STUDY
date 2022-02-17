package chapter15;

import java.io.*;

public class ch15_10 {
    public static void main(String args[]) {
        try {
            FileInputStream fis = new FileInputStream("ch15_08_sample.dat");
            DataInputStream dis = new DataInputStream(fis);

            System.out.println(dis.readInt());
            System.out.println(dis.readFloat());
            System.out.println(dis.readBoolean());
            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
