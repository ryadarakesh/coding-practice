package dynamicprogramming;

public class DPLongestCommonSubSeq {

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        System.out.println(" LCS = "+lcs(s1.toCharArray(), s2.toCharArray()));

        s1 = "AGASTYA";
        s2 = "AGGAASSTTYYAA";
        System.out.println(" LCS = "+lcs(s1.toCharArray(), s2.toCharArray()));

    }


    // Here characters need not be in sequence just need to be in order

    static int lcs (char[] s1, char[] s2) {
        int maxLen=0;
        int[][] memo = new int[s1.length+1][s2.length+1];

        for (int i = 0; i <= s1.length; i++) {
            for (int j = 0; j <= s2.length; j++) {
                if (i == 0 || j == 0) {
                    memo[i][j] = 0;
                } else if (s1[i - 1] == s2[j - 1]) {
                    // If current chars match in both strings we need to add 1 to lcs of prvious char in both string
                    memo[i][j] = memo[i - 1][j - 1] + 1;
                } else {
                    // If current chars dont match we need to compare two possibilities like going back one char in s1 or s2 and get max lcs of those
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                }
                if (memo[i][j] > maxLen) {
                    maxLen = memo[i][j];
                }
            }
        }
        return maxLen;
    }
}
