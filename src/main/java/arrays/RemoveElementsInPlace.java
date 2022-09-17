package arrays;

public class RemoveElementsInPlace {
    public static void main(String[] args) {
        int arr[] = { 3,2,2,3,1,4,3,5};

        int n = removeElement(arr, 3);

        // Print updated array
        for (int i = 0; i <= n; i++)
            System.out.print(arr[i] + " ");
    }
    public static int removeElement(int[] nums, int val) {
        int i=0, j=nums.length-1;
        while (i<j) {
            if (nums[i]==val) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j--;

            } else {
                i++;
            }
        }
        // To handle boundary scenarios
        // [2], 2 should be []
        // [3], 2 should be [3]
        return i<nums.length && nums[i]==val?i : i+1;
    }
}
