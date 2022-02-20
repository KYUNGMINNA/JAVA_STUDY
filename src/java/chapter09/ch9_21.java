package java.chapter09;

import static  java.lang.Math.*;
import static  java.lang.System.*;

public class ch9_21 {
    public static void main(String[] args) {
        int i=Integer.MIN_VALUE;

        out.println("i = "+i);
        out.println("-i = "+(-i));

        try {
            out.printf("negateEXact(%d)= %d%n",    10,negateExact(10));
            out.printf("negateEXact(%d)= %d%n",   -10,negateExact(-10));
            out.printf("negateEXact(%d)= %d%n",i,negateExact(-10));
        }catch (ArithmeticException e){
            out.printf("negateExact(%d)=%d%n",(long)i,negateExact((long)i));
        }

    }
}
