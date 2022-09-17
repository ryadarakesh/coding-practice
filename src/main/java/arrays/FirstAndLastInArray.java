package arrays;

public class FirstAndLastInArray {

    public static void main(String[] args) {
        int[] res = searchRange(new int[]{5,7,8,8,10}, 8);
        System.out.println(res[0]+" "+res[1]);
    }
    public static int[] searchRange(int[] nums, int target) {
        int i=0, j=nums.length-1;
        int[] res= new int[2];
        while (nums[i]<target){
            i++;
        }
        while (nums[j]>target){
            j--;
        }
        if (nums[i]==target) {
            res[0] = i;
        } else {
            res[0] = -1;
        }
        if (nums[j]==target) {
            res[1] = j;
        } else {
            res[1] = -1;
        }
        return res;
    }
}
