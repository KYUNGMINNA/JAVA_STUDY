package java2.chapter08;

public class ch8_06 {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);
        try {
            System.out.println(3);
            System.out.println(4/0);
            System.out.println(5);
        }catch (Exception e){
            System.out.println(6+"  catch(Exception)");
        }
    }
}
