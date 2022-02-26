package java_example.Data_structure;

import java.util.Stack;

public class Stack_Stack {
    public static void main(String[] args) {
        Stack stack=new Stack();

        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(5);
        System.out.println("stack.push(Object item) "+stack);

        System.out.println("stack.pop() "+stack.pop());


        System.out.println("stack.peek() " +stack.peek());

        System.out.println("stack.isEmpty() : "+stack.isEmpty());

        System.out.println("stack.search(Object o)  : "+stack.search(3));
    }
}
