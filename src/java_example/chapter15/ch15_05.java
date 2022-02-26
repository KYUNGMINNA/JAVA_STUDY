package java_example.chapter15;

import java.io.FileInputStream;
import java.io.IOException;

public class ch15_05 {
    public static void main(String args[]) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        int data = 0;

        while((data=fis.read())!=-1) {
            char c = (char)data;
            System.out.print(c);
        }
    }
}
