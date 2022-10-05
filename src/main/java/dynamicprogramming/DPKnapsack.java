package dynamicprogramming;

public class DPKnapsack {

    public static void main(String[] args) {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.println(knapSackNonDP(W, wt, val, n));
        System.out.println(knapSackDP(W, wt, val, n));
    }

    static int knapSackNonDP(int W, int wt[],
                             int val[], int n) {
        if (n == 0 || W == 0) {
            return 0;
        }
        // If current item weight is more that available weigh W we can simply go with next items
        if (wt[n - 1] > W) {
            return knapSackNonDP(W, wt, val, n - 1);
        }
        // If current item is less weight than need consider max of 2 scenarios including and excluding current item
        return Math.max(val[n - 1] + knapSackNonDP(W - wt[n - 1], wt, val, n - 1), knapSackNonDP(W, wt, val, n - 1));
    }

    static int knapSackDP(int Weight, int wt[],
                          int val[], int n) {
        int[][] dp = new int[n + 1][Weight + 1];
        // Here i shows items count to consider
        for (int i = 0; i <= n; i++) {
            for (int cw = 0; cw <= Weight; cw++) {
                // If items are zero or weight is zero set dp as zero
                if (cw == 0 || i == 0) {
                    dp[i][cw] = 0;
                } else if (wt[i - 1] > cw) {
                    // If current weight is greater than required weight set previous total profit without this itesm
                    dp[i][cw] = dp[i - 1][cw];
                } else if (wt[i-1] <= cw) {
                    // set max of current weight without this item and max value without this item plus this item value
                    dp[i][cw] = Math.max(dp[i - 1][cw], val[i - 1] + dp[i - 1][cw - wt[i - 1]]);
                }
            }
        }
        return dp[n][Weight];
    }


}
