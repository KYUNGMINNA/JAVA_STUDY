package java2.chapter08;

public class ch8_04 {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);
        try{
            System.out.println(3);

        }catch (ArithmeticException e){
            System.out.println(4);
        }
        System.out.println(5);
    }
}
