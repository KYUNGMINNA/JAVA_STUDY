package java.chapter11;

import java.util.ArrayList;
import java.util.List;

public class ch11_02 {
    public static void main(String[] args) {
        final int LIMIT=10;
        String source="0123456789abcdefghiABCDEFGHIJ!@#$%^&*";
        int length=source.length();

        List list=new ArrayList(length/LIMIT+10);

        for (int i=0;i<length;i+=LIMIT){
            if (i+LIMIT <length){
                list.add(source.substring(i,i+LIMIT));
            }else{
                list.add(source.substring(i));
            }
        }

        System.out.println(list);
        for (int i=0;i<list.size();i++){
            System.out.println(i+" "+ list.size());
            System.out.println(list.get(i));
        }


    }

}