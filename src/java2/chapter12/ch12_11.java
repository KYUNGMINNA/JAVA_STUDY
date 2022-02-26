package java2.chapter12;

import java.util.*;

public class ch12_11 {
    @SuppressWarnings("deprecation")
    public static void main(String args[]) {
        NewClass11 nc = new NewClass11();

        nc.oldField = 10;
        System.out.println(nc.getOldField());

        @SuppressWarnings("unchecked")
        ArrayList<NewClass11> list = new ArrayList();
        list.add(nc);
    }
}
class NewClass11{
    int newField;

    int getNewField() {
        return newField;
    }

    @Deprecated
    int oldField;

    @Deprecated
    int getOldField() {
        return oldField;
    }
}