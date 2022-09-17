package dynamicprogramming;

import java.util.Arrays;

public class DPPartitionEqualSets {

    public static void main(String[] args) {
        System.out.println(partition(new int[] {2,3,5,6}));
    }

    static boolean partition(int[] nums) {
        /*
        To partition into 2 equal sets each sets sum should match to sum/2
        {2,3,5,6} can be split into {2,6} and {3,5}
         */
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }
        int expectedNum = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][expectedNum + 1];
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 0; i <= nums.length; i++) {
            dp[0][i] = false;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= expectedNum; j++) {
                if (j>nums[i-1]) {
                    dp[i][j] = dp[i - 1][j - nums[i-1]];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[nums.length][expectedNum];
    }
}
