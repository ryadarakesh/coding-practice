package dynamicprogramming;

public class DPNStairReachWays {

    public static void main(String[] args) {
        System.out.println(nStairReachingWays(4));
        System.out.println(nStairReachingWays(5));
    }

    /*
    At a time can climb 1 or 2 stairs
     */
    static int nStairReachingWays (int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i=2; i<=n ; i++) {
            // to get the way to reach ith we can add ways to reach i-1 and ways to reach i-2
            dp[i] = dp[i-2]+dp[i-1];
        }
        return dp[n];
    }
}
