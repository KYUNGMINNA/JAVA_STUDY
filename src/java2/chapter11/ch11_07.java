package java2.chapter11;

import java.util.*;

public class ch11_07 {
    public static void main(String[] args) {

        Stack stack=new Stack();
        Queue q=new LinkedList();

        stack.push("0");
        stack.push("1");
        stack.push("2");

        q.add("0");
        q.add("1");
        q.add("2");

        System.out.println("stack ");
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
        System.out.println("Queue ");
        while(!q.isEmpty()){
            System.out.println(q.poll());
        }

    }
}
