package chapter2;



public class ch2_11 {
    public static void main(String[] args) {
        float f=9.1234567f;
        int i=Float.floatToIntBits(f);
        System.out.printf("%f%n",f);
        System.out.printf("%X",i);
    }
}
