package java_example.chapter08;

public class ch8_17 {
    public static void main(String[] args) {
        try {
            statInstall();
            copyFiles();
            deleteTempFiles();

        }catch (Exception e){
            e.printStackTrace();
            deleteTempFiles();
        }
    }
    static void statInstall(){

    }
    static void copyFiles(){}
    static void  deleteTempFiles(){}
}