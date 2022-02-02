package chapter08;

public class ch8_14 {
    public static void main(String[] args) {
        try {
            method1();
        }catch (Exception e){
            System.out.println("main 메서드에서 예외처리 되었습니다.");
            e.printStackTrace();
        }

    }
    static  void method1() throws Exception{
        throw new Exception();
    }
}
