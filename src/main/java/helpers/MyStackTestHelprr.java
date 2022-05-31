package helpers;

import stack.MyStack;

public class MyStackTestHelprr {
    public static void main(String[] args) throws Exception {
        MyStack<Integer> myStack = new MyStack<>(5);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        System.out.println("Stack Size-"+myStack.size());
        System.out.println("Pop - "+myStack.pop());
        System.out.println("Stack Size-"+myStack.size());
        System.out.println("Peek - "+myStack.peek());
        System.out.println("Stack Size-"+myStack.size());
        System.out.println("Pop - "+myStack.pop());
        System.out.println("Stack Size-"+myStack.size());
        System.out.println("Peek - "+myStack.peek());
        System.out.println("Stack Size-"+myStack.size());
    }
}
