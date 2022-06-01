package stack;

import java.util.Stack;

public class StackReversal {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        reverseStack(st);
        System.out.println("Post Reversal!");
        while (!st.isEmpty()) {
            System.out.println(st.pop());
        }
    }

    /*
        First traverse through recursion till stack is empty. Then for each element from last item call insertAtBottom
         which will empty the current stack till last item with recursion and then inserts our element and then pushes the already bottom inserted the eole back
     */
    static void reverseStack(Stack<Integer> st) {
        if (st.empty()) {
            return;
        }
        int ele = st.pop();
        reverseStack(st);
        insertAtBottom(st, ele);
    }

    // It just empties all already bottom added elements then inserts new element then pushes back from recursion stack the old elements back
    static void insertAtBottom(Stack<Integer> st, int x) {
        if (st.isEmpty()) {
            st.push(x);
        } else {
            int y = st.pop();
            insertAtBottom(st, x);
            st.push(y);
        }
    }
}
