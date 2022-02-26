package java2.chapter02;

public class ch2_09 {
    public static void main(String[] args) {
        short smin=-32768;
        short smax=32767;
        char cmin=0;
        char cmax=65355;

        System.out.println("short min "+smin);
        System.out.println("short min-1 "+(short)(smin-1));
        System.out.println("short max "+smax);
        System.out.println("short max+1 "+(short)(smax+1));
        System.out.println("char min "  +(int)cmin);
        System.out.println("char min-1 "+(int)(--cmin));
        System.out.println("char max "  +(int)cmax);
        System.out.println("char max+1 "+(int)(++cmax));

    }
}
