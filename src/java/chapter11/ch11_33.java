package java.chapter11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ch11_33 {
    public static void main(String[] args) {
        String[] data = { "A","K","A","K","D","K","A","K","K","K","Z","D" };


        HashMap map=new HashMap();

        for (int i=0;i<data.length;i++){
            if (map.containsKey(data[i])){
                Integer value=(Integer) map.get(data[i]);
                map.put(data[i],new Integer(value.intValue())+1);
            }else {
                map.put(data[i],new Integer(1));
            }
        }
        Iterator it=map.entrySet().iterator();

        while(it.hasNext()){
            Map.Entry enry=(Map.Entry)it.next();
            int value=((Integer)enry.getValue()).intValue();
            System.out.println(enry.getKey()+" : "+printBar('#',value)+" "+value);
        }
    }
    public static String printBar(char ch,int value){
        char[] bar=new char[value];

        for (int i=0;i<bar.length;i++) bar[i]=ch;

        return new String(bar);
    }
}
