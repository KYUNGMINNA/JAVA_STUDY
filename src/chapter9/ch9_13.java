package chapter9;

public class ch9_13 {
    public static void main(String[] args) {
        char[] charr=new char[0];
        String s=new String(charr);

        System.out.println(charr.length);
        System.out.println("@@@"+s+"@@@");
        System.out.println(new String("abc"));
    }
}
