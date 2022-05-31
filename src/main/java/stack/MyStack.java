package stack;

public class MyStack<E> {
    Object[] stack;
    int top = -1;
    private int size = 0;

    public MyStack() {
        stack = new Object[10];
        size = 10;
    }

    public MyStack(int size) {
        stack = new Object[10];
        this.size = size;
    }

    public void push(E e) throws Exception {
        if (top + 1 == size) {
            throw new Exception("Stack is full");
        }
        stack[++top] = e;
        System.out.println("Pushed - " + e);
    }

    public E pop() throws Exception {
        if (top == -1) {
            throw new Exception("Stack is Empty");
        }
        return (E) stack[top--];
    }

    public E peek() throws Exception {
        if (top == -1) {
            throw new Exception("Stack is Empty");
        }
        return (E) stack[top];
    }

    public int size() {
        return top + 1;
    }

}
