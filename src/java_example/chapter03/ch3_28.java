package java_example.chapter03;

public class ch3_28 {
    public static void main(String[] args) {
        int x=0XAB, y=0xF;

        System.out.println(toBinaryString(x));
        System.out.println(toBinaryString(y));
        System.out.println(toBinaryString(x|y));
        System.out.println(toBinaryString(x&y));
        System.out.println(toBinaryString(x^y));
        System.out.println(toBinaryString(x^y^y));

    }
    static String toBinaryString(int x){
        String zero="00000000000000000000000000000000";
        String tmp=zero+Integer.toBinaryString(x);
        return tmp.substring(tmp.length()-32);
    }
}
