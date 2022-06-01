package stack;

import java.util.Stack;

public class PostfixEvaluate {

    public static void main(String[] args) {
        evaluatePostFix("34*56+*");
        evaluatePostFix("34*56+*7");
        evaluatePostFix("34*56+*+");
    }

    static void evaluatePostFix(String s) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                stack.push(Integer.parseInt(Character.toString(ch)));
            } else {
                try {
                    if (ch == '+') {
                        stack.push(stack.pop() + stack.pop());
                    } else if (ch == '-') {
                        stack.push(stack.pop() - stack.pop());
                    } else if (ch == '*') {
                        stack.push(stack.pop() * stack.pop());
                    } else if (ch == '/') {
                        stack.push(stack.pop() / stack.pop());
                    }
                } catch (Exception e) {
                    System.out.println("Failed to evaluate expression - " + s);
                }
            }
        }
        if (stack.size() == 1) {
            System.out.println("Result - " + stack.pop());
        } else {
            System.out.println("Invalid expression" + s);
        }
    }
}
