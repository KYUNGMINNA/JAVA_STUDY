package java_example.chapter08;

public class ch8_13 {
    public static void main(String[] args) {
        method1();

    }
    static  void method1(){
        try{
            throw new Exception();
        }catch (Exception e){
            System.out.println("method1메서드에서 예외처리 되었습니다");
            e.printStackTrace();
        }
    }
}
