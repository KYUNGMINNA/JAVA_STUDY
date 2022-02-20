package java.chapter05;

public class ch5_14 {
    public static void main(String[] args) {
        String src="ABCDE";

        for (int i=0;i<src.length();i++){
            char ch=src.charAt(i);
            System.out.println("src.charAt("+i+")"+ch);
        }
        char[] ch2=src.toCharArray();
        System.out.println(ch2);
    }
}
