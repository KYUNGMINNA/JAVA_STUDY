package java.Data_structure;

import java.util.LinkedList;

public class Queue_LinkedList {
    public static void main(String[] args){
        LinkedList Queue=new LinkedList();

        //추가 --offer
        Queue.offer(1);  //autoboxing
        Queue.offer(2);
        Queue.offer(3);
        System.out.println("offer :"+Queue);

        //삭제 -- poll
        System.out.println("poll :"+Queue.poll());

        //첫번 째 요소 검색
        System.out.println("peek:" +Queue.peek());

        //비어 있는지 여부
        System.out.println("empty :"+Queue.isEmpty());
    }
}
