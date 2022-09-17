package arrays;

import helpers.ArrayUtils;

public class NextPermutationNumber {
    public static void main(String[] args) {
        NextPermutationNumber p = new NextPermutationNumber();
        int[] a= new int[]{ 1, 2, 3, 6, 5, 4 };
        p.nextPermutation(a);
        ArrayUtils.printElements(a);
    }
    /*
    Here we start from last and see which num is less than its previous num so that we have scope to swap to make big number
    Once find that number we scan from back to see the first number which is greater than above to swap
    After swapping we need to revrese the numbers from post first step position as they are in ascending order would have greater number
    step 1: scanning from last-1 index 3 is less than 6 hence pivot is 3
    Next scanning from last for candidate greater than 3 is
     */

    public void nextPermutation(int[] nums) {
        int i;
        for (i=nums.length-2; i>=0; i--) {
            if (nums[i]<nums[i+1]) {
                break;
            }
        }
        // Already highest number is given hence as per question we need to give reverse means shortest number
        if (i==0) {
            reverse(nums, 0, nums.length-1);
            return;
        }
        int j;
        for (j=nums.length-1; j>i; j--) {
            if (nums[j]>nums[i]) {
                break;
            }
        }
        swap(nums, i, j);
        reverse(nums, i+1, nums.length-1);
    }

    private void swap (int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        int i=start, j=end;
        while (i<j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
