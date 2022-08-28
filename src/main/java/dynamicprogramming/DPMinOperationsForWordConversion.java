package dynamicprogramming;

public class DPMinOperationsForWordConversion {
    public static void main(String[] args) {
        System.out.println(minOpsForWordConversion("cat".toCharArray(), "caps".toCharArray()));
    }

    static int minOpsForWordConversion(char[] s1, char[] s2) {
        int[][] memo = new int[s1.length + 1][s2.length + 1];
        // Here we are trying to convert s1 to s2
        for (int i = 0; i <= s1.length; i++) {
            for (int j = 0; j <= s2.length; j++) {
                if (i == 0) {
                    memo[i][j] = j;
                } else if (j == 0) {
                    memo[i][j] = i;
                } else if (s1[i - 1] == s2[j - 1]) {
                    memo[i][j] = memo[i - 1][j - 1];
                } else {
                    // We need to get min of insert , delete and replace sceanario and add one op
                    // memo[i - 1][j] gives delete, memo[i][j - 1] insert,memo[i - 1][j - 1] replace
                    memo[i][j] = Math.min(Math.min(memo[i - 1][j], memo[i][j - 1]), memo[i - 1][j - 1]) + 1;
                }
            }
        }
        return memo[s1.length][s2.length];
    }
}
