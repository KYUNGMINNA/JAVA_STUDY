package chapter9;

import java.io.UnsupportedEncodingException;
import java.util.StringJoiner;
public class ch9_15 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str="가";

        byte[] barr=str.getBytes("UTF-8");
        byte[] bar2=str.getBytes("CP949");

        System.out.println("UTF-8"+joinByteArr(barr));
        System.out.println("CP949"+joinByteArr(bar2));

        System.out.println("UTF-8:"+new String(barr,"UTF-8"));
        System.out.println("CP949:"+new String(barr,"CP949"));
    }
    static String joinByteArr(byte[] barr){
        StringJoiner sj=new StringJoiner(":","[","]");
        for (byte b: barr) sj.add(String.format("%02X",b));

        return sj.toString();
    }
}
