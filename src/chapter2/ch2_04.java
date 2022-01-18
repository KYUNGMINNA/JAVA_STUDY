package chapter2;

public class ch2_04 {
    public static void main(String[] args) {
        byte b=1;

        short s=2;

        char c='A';

        int finger=10;

        long big=100_000_000_000L;
        long hex=0XFFFF_FFFF_FFFF_FFFFL;

        int octnum=010;
        int hexnum=0x10;
        int binnum=0b10;

        System.out.printf("b=%d%n",b);
        System.out.printf("s=%d%n",s);
        System.out.printf("c=%c, %d %n",c,(int)c);
        System.out.printf("finger=[%5d]%n",finger);
        System.out.printf("finger=[%-5d]%n",finger);
        System.out.printf("finger=[%05d]%n",finger);
        System.out.printf("big=%d%n",big);
        System.out.printf("hex=%#X%nhex=%#X%n",hex,hex);
        System.out.printf("octnum(접미사포함)=%#o,접미사 미포함:%o,10진수=%d%n",octnum,octnum,octnum);
        System.out.printf("hexnum(접미사포함)=%#x,접미사 미포함:%x,10진수=%d%n",hexnum,hexnum,hexnum);
        System.out.printf("binnum=%s %d%n",Integer.toBinaryString(binnum),binnum);
    }
}
