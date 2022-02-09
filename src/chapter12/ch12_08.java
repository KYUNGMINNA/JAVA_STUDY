package chapter12;

import java.util.EmptyStackException;
import java.util.Vector;

public class ch12_08 extends Vector {
    public Object push(Object item){
        addElement(item);
        return item;
    }
    public Object pop(){
        Object obj=peek();
        removeElementAt(size()-1);
        return obj;
    }
    public Object peek(){
        int len=size();

        if (len==0){
            throw new EmptyStackException();
        }
        return elementAt(len-1);
    }
    public Object empty(){
        return size()==0;
    }
    public  Object search(Object o ){
        int i=lastIndexOf(o);

        if (i>0){
            return size()-1;
        }
        return -1;
    }
}
