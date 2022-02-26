package java2.chapter15;

import java.io.*;

public class ch15_13 {
    public static void main(String args[]) {
        int sum   = 0;
        int score = 0;

        try (FileInputStream fis = new FileInputStream("ch15_11_score.dat");
             DataInputStream dis = new DataInputStream(fis))
        {

            while(true) {
                score = dis.readInt();
                System.out.println(score);
                sum += score;
            }
        } catch (EOFException e) {
            System.out.println("점수의 총합은 " + sum +"입니다");
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}
