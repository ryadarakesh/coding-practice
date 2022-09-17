package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ParenthesisMatcher {
    static Map<Character, Character> map = new HashMap<>();
    static {
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
    }
    public static boolean isValid(String A) {
        Stack<Character> st = new Stack<>();
        for (int i=0; i< A.length(); i++) {
            if (map.containsKey(A.charAt(i))) {
                if (st.isEmpty()) {
                    return false;
                } else {
                    char ch = st.pop();
                    if (map.get(A.charAt(i)) != ch) {
                        return false;
                    }
                }
            } else {
                st.push(A.charAt(i));
            }
        }
        if (!st.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValid("[]{}()"));
        System.out.println(isValid("[][{}()"));
    }
}
