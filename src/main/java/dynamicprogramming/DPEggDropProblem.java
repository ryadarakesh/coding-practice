package dynamicprogramming;

public class DPEggDropProblem {

    /*
    We need to find max tries with given number of eggs and floor
     */

    static int eggDropsNonDP(int eggs, int floors) {
        if (floors == 0 || floors == 1) {
            return floors;
        }
        // If there is only one eggs we need max count equal to floors to get the desired floor
        if (eggs == 1) {
            return floors;
        }
        int minTrials = Integer.MAX_VALUE;
        for (int i = 1; i <= floors; i++) {
            int worstCaseTrials = Math.max(eggDropsNonDP(eggs, floors - i), eggDropsNonDP(eggs - 1, i - 1));
            if (worstCaseTrials < minTrials) {
                minTrials = worstCaseTrials;
            }
        }

        return minTrials + 1;
    }

    static int eggDropsDP(int eggs, int floors) {
        int[][] dp = new int[eggs+1][floors+1];
        // If eggs count is 1 we need max trials equal to floors
        for (int f = 1; f <= floors; f++) {
            dp[1][f] = f;
        }
        for (int e = 1; e <= eggs; e++) {
            dp[e][1] = 1;
            dp[e][0] = 0;
        }

        for (int i=2; i<=eggs; i++) {
            for (int j=2; j<=floors; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int x=1; x<=j; x++) {
                    int res = Math.max(dp[i][j-x], dp[i-1][j-1])+1;
                    if (dp[i][j]>res) {
                        dp[i][j] = res;
                    }
                }
            }
        }
        return dp[eggs][floors];
    }

    public static void main(String[] args) {
        System.out.println("Minimum number of "
                + "trials in worst case with "
                + 2 + " eggs and " + 10
                + " floors is " + eggDropsNonDP(2, 10));
        System.out.println("DP - Minimum number of "
                + "trials in worst case with "
                + 2 + " eggs and " + 10
                + " floors is " + eggDropsDP(2, 10));
    }

}
