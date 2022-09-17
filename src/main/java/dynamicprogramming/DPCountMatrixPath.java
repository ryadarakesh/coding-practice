package dynamicprogramming;

public class DPCountMatrixPath {
    /*
    It is to find number of paths to reach from (0,0) to (m,n) in a mXn matric
     */
    public static void main(String[] args) {
        System.out.println(countPathDP(5,5));
    }
    static int countPathDP(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    // If i==0 only one way in vertical line possible
                    // if j==0 only one way which is horizontal possible
                    dp[i][j] = 1;
                } else {
                    // we can reach reach i,j via two way one is from top and another from left so adding those combinations would be current reachability
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
