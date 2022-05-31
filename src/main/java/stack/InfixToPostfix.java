package stack;

import java.util.*;

public class InfixToPostfix {
    public static void main(String[] args) {
        System.out.println("Infix -  " + "(A+B)+(C+D)");
        System.out.println("Postfix -  " + getPostFix("(A+B)+(C+D)"));

        System.out.println("Infix -  " + "A+B*C+D");
        System.out.println("Postfix -  " + getPostFix("A+B*C+D"));

        System.out.println("Infix -  " + "a+b*(c*d-e)*(f+g*h)-i");
        System.out.println("Postfix -  " + getPostFix("a+b*(c*d-e)*(f+g*h)-i"));
    }


    static Map<Character, Integer> precedence;

    static {
        precedence = new HashMap();
        precedence.put('+', 1);
        precedence.put('-', 1);
        precedence.put('*', 2);
        precedence.put('/', 2);
    }
    /*
    Scan from left and do below
    1. If operand is found add to result
    2. If ( found push into stack
    3. If ) is found pop and add to result till ( found and pop (
    4. Else it is operator do below
       a. If Stack is empty add operator to stack
       b. If while stack not empty and top element is not ( and top operators precedency is higher than current operator pop and add to result and add current op to stack
     */

    static String getPostFix(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuffer res = new StringBuffer("");
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isAlphabetic(ch)) {
                res.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.empty() && stack.peek() != '(') {
                    res.append(stack.pop());
                }
                stack.pop();
            } else {// Operators
                if (stack.empty()) {
                    stack.push(ch);
                } else {
                    // Operator
                    if (stack.empty()) {
                        stack.push(ch);
                    } else {
                        // Here only operator or ( is possible and if only high precedency is found in stack then only pop and add to result
                        while (!stack.empty() && stack.peek() != '(' && precedence.get(stack.peek()) > precedence.get(ch)) {
                            res.append(stack.pop());
                        }
                        stack.push(ch);
                    }
                }
            }
        }
        while (!stack.empty()) {
            res.append(stack.pop());
        }
        return res.toString();
    }
}
