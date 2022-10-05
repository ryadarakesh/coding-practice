package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Here we need to find whether sum of any sub array elements matching to target
 */
public class SubArraySumMatchTarget {

    /*
    https://www.educative.io/courses/algorithms-ds-interview/mE4N0JJD6vp
    Here for each position we find the prefix sum mean what is the sum of all elements till that index and add the sum to map with index as value
    For any position if the current position prefix sum - target is already some positions prefix sum then from that position to current is the sub array
     */
    public static int[] subarraySum(int[] arr, int target) {
        // WRITE YOUR BRILLIANT CODE HERE
        int[] res = new int[2];
        Map<Integer, Integer> prefixSumTillPos = new HashMap<>();
        int sum =0;
        for (int i=0; i<arr.length; i++) {
           sum = sum+arr[i];
           int reqSum = sum-target;
           if (prefixSumTillPos.containsKey(reqSum)) {
               res[0] = prefixSumTillPos.get(reqSum)+1;
               // right is exclusive
               res[1]=i+1;
               return res;
           }
            prefixSumTillPos.put(sum, i);
        }
        if (sum==target) {
            res[0] = 0;
            // right is exclusive
            res[1]=arr.length;
        }
        return res;
    }

    public static void main(String[] args) {
        Arrays.stream(subarraySum(new int[]{1,3,-3,8,5,7}, 5)).forEach(System.out::println);// [2,4)
        // prefix sums 1,4,1,9,4,11
        // At value 8 8-target would become 8-5=4 and 4 already there as sum at index 1
        /// Hence from Index 2 to 3 (inclusive) or else we can say 2 to 4(exclusive matches target sum.
    }
}
