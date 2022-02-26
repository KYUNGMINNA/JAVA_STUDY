package java_example.chapter10;

import java.util.*;
import java.text.*;

public class ch10_14 {
    public static void main(String[] args) {
        DateFormat df1=new SimpleDateFormat("yyyy년 MM월 dd일");
        DateFormat df2=new SimpleDateFormat("yyyy/MM/dd");

        try {
            Date d= df1.parse("2015년 11월 23일");
            System.out.println(df2.format(d));
        }catch (Exception e){

        }

    }
}
