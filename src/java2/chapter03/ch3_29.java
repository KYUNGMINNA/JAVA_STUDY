package java2.chapter03;

public class ch3_29 {
    public static void main(String[] args) {
        byte p=10;
        byte n=-10;

        System.out.println("p="+p+"  tobinaryString="+toBinaryString(p));

        System.out.println("~p="+~p+"  tobinaryString="+toBinaryString(~p));
        System.out.println("~p="+(~p+1)+"  tobinaryString="+toBinaryString(~p+1));
        System.out.println("p="+~~p+"  tobinaryString="+toBinaryString(~~p));
        System.out.println();
        System.out.println(n);
        System.out.println(~(n-1));

    }
    static String toBinaryString(int x){
        String zero="00000000000000000000000000000000";
        String tmp=zero+Integer.toBinaryString(x);
        return tmp.substring(tmp.length()-32);
    }
}
