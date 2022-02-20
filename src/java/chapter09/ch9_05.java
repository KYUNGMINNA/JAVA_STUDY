package java.chapter09;

public class ch9_05 {
    public static void main(String[] args) {
        String str=new String("KOREA");
        java.util.Date today=new java.util.Date();

        System.out.println("String 클래스,Data클래스는 tosring시 문자열로 나옴");
        System.out.println(str);
        System.out.println(str.toString());
        System.out.println(today);
        System.out.println(today.toString());
    }

}
