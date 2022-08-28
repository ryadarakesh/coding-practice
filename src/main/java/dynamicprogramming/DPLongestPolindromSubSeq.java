package dynamicprogramming;

public class DPLongestPolindromSubSeq {

    public static void main(String[] args) {
        System.out.println(longestPolindromSubSeqRecursive(new char[] {'a','b','c','e','c','a'}, 0, 5));// aceca -5
        System.out.println(longestPolindromSubSeqRecursive(new char[] {'a','b','c','e','c','b','a'}, 0, 6));//abcecba-7
    }

    static int longestPolindromSubSeqRecursive(char[] s, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (start == end) {
            return 1;
        }

        if (s[start] == s[end]) {
            return 2 + longestPolindromSubSeqRecursive(s, start + 1, end - 1);
        } else {
            return Math.max(longestPolindromSubSeqRecursive(s, start + 1, end), longestPolindromSubSeqRecursive(s, start, end - 1));
        }
    }
}
