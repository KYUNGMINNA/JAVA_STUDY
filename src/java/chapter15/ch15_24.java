package java.chapter15;

import java.io.*;

public class ch15_24 {
    public static void main(String[] args) {
       PrintStream ps=null;
       FileOutputStream fos=null;

       try{
           fos=new FileOutputStream("C:\\Users\\kyungmin\\IdeaProjects\\JAVA_STUDY\\src\\java.chapter15/test.txt");
           ps=new PrintStream(fos);
           System.setOut(ps);
       }catch (FileNotFoundException e){
           System.err.println("File Not Found.");
       }
        System.out.println("hello by System.out");
        System.err.println("heelo by System.err");
    }
}
