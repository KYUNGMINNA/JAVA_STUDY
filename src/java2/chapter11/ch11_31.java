package java2.chapter11;

import java.util.*;

public class ch11_31 {
    public static void main(String[] args) {
        HashMap hashMap=new HashMap();
        hashMap.put("김자바",new Integer(100));
        hashMap.put("이자바",new Integer(100));
        hashMap.put("강자바",new Integer(80));
        hashMap.put("안자바",new Integer(90));
        Set set=hashMap.entrySet();
        Iterator it=set.iterator();

        while(it.hasNext()){
            Map.Entry e=(Map.Entry)it.next();
            System.out.println("이름 : "+e.getKey()+", 점수 :"+e.getValue());
        }

        set=hashMap.keySet();
        System.out.println("참가자 명단 : "+set);


        Collection values= hashMap.values();
        it=values.iterator();

        int total=0;

        while(it.hasNext()){
            Integer i=(Integer) it.next();
            total+=i.intValue();
        }

        System.out.println("총점 :"+total);
        System.out.println("평균 :"+(float)total/ set.size());
        System.out.println("최고 점수 :"+Collections.max(values));
        System.out.println("최저 점수 :"+Collections.min(values));
    }
}
