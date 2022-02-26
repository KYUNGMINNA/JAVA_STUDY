package java2.chapter03;

public class ch3_30 {
    static String toBinaryString(int x){
        String zero="00000000000000000000000000000000";
        String tmp=zero+Integer.toBinaryString(x);
        return  tmp.substring(tmp.length()-32);

    }

    public static void main(String[] args) {
        int dec=8;

        System.out.println("8>>0 =   "+toBinaryString(dec>>0));
        System.out.println("8>>1 =   "+toBinaryString(dec>>1));
        System.out.println("8>>2 =   "+toBinaryString(dec>>2));
        System.out.println("8<<0 =   "+toBinaryString(dec<<0));
        System.out.println("8<<1 =   "+toBinaryString(dec<<1));
        System.out.println("8<<2 =   "+toBinaryString(dec<<2));



        dec=-8;

        System.out.println("-8>>0 =  "+toBinaryString(dec>>0));
        System.out.println("-8>>1 =  "+toBinaryString(dec>>1));
        System.out.println("-8>>2 =  "+toBinaryString(dec>>2));
        System.out.println("-8<<0 =  "+toBinaryString(dec<<0));
        System.out.println("-8<<1 =  "+toBinaryString(dec<<1));
        System.out.println("-8<<2 =  "+toBinaryString(dec<<2));

    }
}
