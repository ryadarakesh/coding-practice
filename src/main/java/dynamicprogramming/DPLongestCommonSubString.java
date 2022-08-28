package dynamicprogramming;

public class DPLongestCommonSubString {

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        System.out.println(" LCS = " + longestCommonSubString(s1.toCharArray(), s2.toCharArray()));

        s1 = "AGASTYA";
        s2 = "AGASSTTYYAA";
        System.out.println(" LCS = " + longestCommonSubString(s1.toCharArray(), s2.toCharArray()));
    }


    static int longestCommonSubString(char[] s1, char[] s2) {
        int maxLen = 0;
        int[][] memo = new int[s1.length + 1][s2.length + 1];

        for (int i = 0; i <= s1.length; i++) {
            for (int j = 0; j <= s2.length; j++) {
                if (i == 0 || j == 0) {
                    memo[i][j] = 0;
                } else if (s1[i - 1] == s2[j - 1]) {
                    // If current chars match in both strings we need to add 1 to lcs of previous char in both string
                    memo[i][j] = memo[i - 1][j - 1] + 1;
                } else {
                    // If current chars dont match we need to mark it as zero as this combination can't be part of substring
                    memo[i][j] = 0;
                }
                if (memo[i][j] > maxLen) {
                    maxLen = memo[i][j];
                }
            }
        }
        return maxLen;
    }
}
