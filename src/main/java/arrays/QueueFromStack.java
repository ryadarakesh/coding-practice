package arrays;

import java.util.Stack;

public class QueueFromStack {

    public static void main(String[] args) throws Exception {
        QueueFromStack queue = new QueueFromStack();
        queue.enqueue("123");
        queue.enqueue("456");
        System.out.println(queue.dequeue());
        queue.enqueue("789");
        System.out.println(queue.dequeue());
        queue.enqueue("abc");
        queue.enqueue("xyz");
        System.out.println(queue.dequeue());
        System.out.println(queue.size());
    }

    private Stack<String> s1;
    private Stack<String> s2;
    int size=0;

    public QueueFromStack() {
        s1 = new Stack<String>();
        s2 = new Stack<String>();
    }

    public int size() {
        return size;
    }

    public void enqueue(String str) {
        s1.push(str);
        size++;
    }


    public String dequeue() throws Exception {
        if (size == 0) {
            throw new Exception("Queue is empty.");
        }
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        String ele = s2.pop();
        size--;
        return ele;
    }

}
