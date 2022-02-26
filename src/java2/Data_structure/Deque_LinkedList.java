package java2.Data_structure;

import java.util.LinkedList;

public class Deque_LinkedList {
    public static void main(String[] args) {
        LinkedList Deque=new LinkedList();

        Deque.offerLast(1);
        Deque.offerLast(2);
        Deque.offerLast(3);
        System.out.println("offerLast :"+Deque);

        System.out.println("poll first :"+Deque.pollFirst());
        System.out.println("Deque :"+Deque);

        System.out.println("poll Last : "+Deque.pollLast());
        System.out.println("Deque :"+Deque);

        System.out.println("offer Frist :"+Deque.offerFirst(8));
        System.out.println("Deque :"+Deque);

        System.out.println("peek First: "+Deque.peekFirst());
        System.out.println("peek Last: "+Deque.peekLast());

    }
}
