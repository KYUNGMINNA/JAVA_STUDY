package java2.chapter08;

public class ch8_08 {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);

        try {
            System.out.println(3);
            System.out.println(0/0);
            System.out.println(4);
        }catch (ArithmeticException ae){
            ae.printStackTrace();
            System.out.println("메시지는 :"+ae.getMessage());
        }
        System.out.println(6);
    }
}
