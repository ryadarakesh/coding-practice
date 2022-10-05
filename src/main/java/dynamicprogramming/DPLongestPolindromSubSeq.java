package dynamicprogramming;

public class DPLongestPolindromSubSeq {

    public static void main(String[] args) {
        System.out.println(longestPolindromSubSeqRecursive(new char[] {'a','b','c','e','c','a'}, 0, 5));// aceca -5
        System.out.println(longestPolindromSubSeqRecursive(new char[] {'a','b','c','e','c','b','a'}, 0, 6));//abcecba-7
    }

    static int longestPolindromSubSeqRecursive(char[] s, int left, int right) {
        if (left > right) {
            return 0;
        }
        if (left == right) {
            return 1;
        }

        if (s[left] == s[right]) {
            return 2 + longestPolindromSubSeqRecursive(s, left + 1, right - 1);
        } else {
            return Math.max(longestPolindromSubSeqRecursive(s, left + 1, right), longestPolindromSubSeqRecursive(s, left, right - 1));
        }
    }
}
