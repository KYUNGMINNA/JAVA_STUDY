package java2.chapter08;

import java.io.*;

public class ch8_15 {
    public static void main(String[] args) {
        File f=createFile("asd");
        System.out.println(f.getName()+"파일 생성");

    }
    static File createFile(String fileName){
        try {
            if (fileName==null || fileName.equals(""))
                throw new Exception("파일이름 유효안함");

        }catch (Exception e){
            fileName="제목없음.txt";
        }finally {
            File f=new File(fileName);
            createNewFile(f);
            return f;
        }
    }
    static void createNewFile(File f){
        try {
            System.out.println("File 메서드 createNewFile --boolean ");
            f.createNewFile();
        }catch (Exception e){

        }
    }
}
