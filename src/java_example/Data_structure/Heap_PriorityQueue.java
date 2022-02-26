package java_example.Data_structure;

import java.util.Queue;
import java.util.PriorityQueue;

public class Heap_PriorityQueue {
    public  static void main(String[] args){
        Queue priorityqueue=new PriorityQueue();

        // offer
        priorityqueue.offer(1);
        priorityqueue.offer(8);
        priorityqueue.offer(4);
        priorityqueue.offer(0);
        priorityqueue.offer(2);
        System.out.println(" 1 ->8->4->0->2");
        System.out.println("offer :"+priorityqueue);

        //poll
        System.out.println("poll :"+priorityqueue.poll());
        System.out.println("poll :"+priorityqueue.poll());
        System.out.println("poll :"+priorityqueue.poll());
        System.out.println("poll :"+priorityqueue.poll());


        //empty
        System.out.println("empty :"+priorityqueue.isEmpty());


    }
}
