package java.chapter08;

import java.io.*;
public class ch8_16 {
    public static void main(String[] args) {

        try{
            File f=createFile(args[0]);
            System.out.println(f.getName()+"파일이 성공적으로 생산되었습니다.");
        }catch (Exception e){
            System.out.println(e.getMessage()+"다시 입력해 주시길 바랍니다.");

        }

    }
    static  File createFile(String fileName) throws Exception{
        if (fileName==null || fileName.equals("")){
            throw new Exception();
        }
        File f=new File(fileName);
        f.createNewFile();
        return f;
    }
}
