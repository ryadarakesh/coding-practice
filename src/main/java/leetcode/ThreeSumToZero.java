package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreeSumToZero {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);
        System.out.println(result);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        boolean found = false;

        // sort array elements
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            // initialize left and right
            int l = i + 1;
            int r = n - 1;
            int x = nums[i];
            while (l < r) {
                if (x + nums[l] + nums[r] == 0) {
                    // print elements if it's sum is zero
                    System.out.print(x + " ");
                    System.out.print(nums[l] + " ");
                    System.out.println(nums[r] + " ");
                    lists.add(Arrays.asList(x, nums[l], nums[r]));
                    l++;
                    r--;
                }

                // If sum of three elements is less
                // than zero then increment in left
                else if (x + nums[l] + nums[r] < 0)
                    l++;

                    // if sum is greater than zero then
                    // decrement in right side
                else
                    r--;
            }
        }
            return lists;
        }
        
}
