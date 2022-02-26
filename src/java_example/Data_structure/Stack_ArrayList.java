package java_example.Data_structure;

import java.util.ArrayList;

public class Stack_ArrayList {
    public static void main(String[] args){
        ArrayList stacks=new ArrayList();  //default는 크기가 10인 ArrayList생성

        //추가  - push
        stacks.add(new Integer(1));
        stacks.add(new Integer(2));
        stacks.add(3);
        System.out.println("push : "+stacks);

        //맨 위 객체 삭제 - pop
        //+stacks.remove(stacks.size()-1)
        System.out.println("remove : " +stacks.remove(stacks.size()-1));

        //맨위 객체  -- peek
        //stacks.get(stacks.size()-1)
        System.out.println("peek :"+stacks.get(stacks.size()-1));


        //객체 위치 반환 --search
        //stacks.indexOf(new Integer(1))  --여기서는 객체 1 위치 검색 (위치는 1부터 시작)
        System.out.println("search : "+stacks.indexOf(new Integer(1)+1));

        //비어 있는지 여부 -- empty
        //stacks.isEmpty()
        System.out.println("empty :"+stacks.isEmpty());

    }
}
