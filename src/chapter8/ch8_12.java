package chapter8;

public class ch8_12 {
    public static void main(String[] args) throws  Exception{
        System.out.println("아무도 예외 처리 안해서 JVM 예외처리기 동작 ");
        method1();
    }
    static void method1() throws Exception{
        method2();
    }
    static  void method2() throws  Exception{
        throw new Exception();
    }
}
