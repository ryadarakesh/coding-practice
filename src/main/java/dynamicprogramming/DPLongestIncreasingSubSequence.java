package dynamicprogramming;

/*
Input: arr[] = {3, 10, 2, 1, 20}
Output: Length of LIS = 3
The longest increasing subsequence is 3, 10, 20

Input: arr[] = {3, 2}
Output: Length of LIS = 1
The longest increasing subsequences are {3} and {2}

Input: arr[] = {50, 3, 10, 7, 40, 80}
Output: Length of LIS = 4
The longest increasing subsequence is ex: {3, 7, 40, 80}
 */
public class DPLongestIncreasingSubSequence {

    static int getLIS(int[] nums) {
        int[] lis = new int[nums.length];
        // Initialize with 1 as minimum LIS is 1 even if entire array is in decreasing order
        for (int i = 0; i < nums.length; i++) {
            lis[i] = 1;
        }/*
        For each position we start comparing prvious values and if value is less than current
        we check the lis value is greater, if so update current lis with plus 1
        */
        for (int j = 1; j < nums.length; j++) {
            for (int k = 0; k < j; k++) {
                if (nums[j] > nums[k] ) {
                    // Max of current lis or (previous+1) k+1
                    lis[j] = Math.max(lis[j], lis[k]+1);
                }
            }
        }
        int max = 0;
        for (int x = 0; x < lis.length; x++) {
            if (lis[x] > max) {
                max = lis[x];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(getLIS(new int[]{ 10, 22, 9, 33, 21, 50, 41, 60 })); // 5
        System.out.println(getLIS(new int[]{ 10, 22, 9,7, 33, 21, 50,55, 41, 60 })); // 6
    }
}
