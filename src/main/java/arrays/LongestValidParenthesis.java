package arrays;

import java.util.Stack;

public class LongestValidParenthesis {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()(()))))"));
        System.out.println(longestValidParentheses("()(()"));
    }
    public static int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        int maxLen=0;
        int currentLen=0;
        for (char ch : s.toCharArray()) {
            if (ch=='(') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty()) {
                  stack.pop();
                  currentLen=currentLen+2;
                  maxLen = Math.max(maxLen, currentLen);
                } else {
                    currentLen = 0;
                }
            }
        }
        if (stack.isEmpty()) {
            maxLen = Math.max(maxLen, currentLen);
        }
        return maxLen;
    }
}
