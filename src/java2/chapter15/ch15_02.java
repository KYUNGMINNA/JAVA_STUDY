package java2.chapter15;

import java.io.*;
import java.util.Arrays;

public class ch15_02 {
    public static void main(String[] args) {
        byte[] inSrc={0,1,2,3,4,5,6,7,8,9};
        byte[] outSrc=null;
        byte[] temp=new byte[10];

        ByteArrayInputStream input=null;
        ByteArrayOutputStream output=null;

        input=new ByteArrayInputStream(inSrc);
        output=new ByteArrayOutputStream();

        input.read(temp,0, temp.length);
        output.write(temp,5,5);

        outSrc=output.toByteArray();

        System.out.println("Input source"+Arrays.toString(inSrc));
        System.out.println("temp "+Arrays.toString(temp));
        System.out.println("Output source "+Arrays.toString(outSrc));

    }
}
