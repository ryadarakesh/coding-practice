package arrays;

import helpers.ArrayUtils;

public class MinRewards {
    /**
     * Given input is student grades the result should be in such a way that the total sum should be minimum
     * And the consecutive students rewards should be as per their scores not in other way
     * @param args
     */
    public static void main(String[] args) {
        ArrayUtils.printElements(getMinRewards(new int[]{8, 4, 2, 1, 3, 6, 7, 9, 5}));
        System.out.println("");
        ArrayUtils.printElements(getMinRewards(new int[]{8, 4, 2, 1, 3, 6, 7, 9, 5, 6, 10, 8}));
    }

    static int[] getMinRewards(int[] a) {
        int[] rewardsResult = new int[a.length];
        rewardsResult[0] = 1;
        // First traverse from left to right if there is increase in grades increase rewards otherwise just keep 1
        // as we are going to check increasing order below in reverse order next to handle it
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                rewardsResult[i] = 1;
            } else if (a[i] > a[i - 1]) {
                rewardsResult[i] = rewardsResult[i - 1] + 1;
            }
        }
        // Now traverse from right to left if grade increases place Max of previous reward caliculated in forward direction or right result +1
        for (int i = a.length - 2; i >= 0; i--) {
            if (a[i] > a[i + 1]) {
                rewardsResult[i] = Math.max(rewardsResult[i], rewardsResult[i + 1] + 1);
            }
        }
        return rewardsResult;
    }
}
