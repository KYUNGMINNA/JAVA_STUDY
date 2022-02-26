package java_example.chapter15;

import java.io.*;

public class ch15_17 {
    public static void main(String args[]) {
        try {
            FileReader fr= new FileReader(args[0]);
            FileWriter fw= new FileWriter(args[1]);

            int data =0;
            while((data=fr.read())!=-1) {
                if(data!='\t' && data!='\n' && data!=' ' && data !='\r')
                    fw.write(data);
            }

            fr.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
