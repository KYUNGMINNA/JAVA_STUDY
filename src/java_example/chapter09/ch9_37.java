package java_example.chapter09;

import java.util.Scanner;
import java.io.File;

public class ch9_37 {
    public static void main(String[] args)  throws  Exception{
        Scanner sc=new Scanner(new File("C:\\Users\\kyungmin\\Desktop\\data3.txt"));

        int cnt=0;
        int totalsum=0;

        while(sc.hasNextLine()){
            String line=sc.nextLine();
            Scanner sc2=new Scanner(line).useDelimiter(",");
            int sum=0;

            while(sc2.hasNextLine()){
                totalsum+=sum;
                cnt++;
            }
            System.out.println("Line :"+cnt+ ",Total : "+totalsum);

        }
    }
}
