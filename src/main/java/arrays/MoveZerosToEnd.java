package arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MoveZerosToEnd {
    public static void moveZeros(int[] nums) {
        int zeroPos = -1;
        int currentPos = 0;
        while (currentPos<nums.length) {
            if (nums[currentPos]==0) {
                if (zeroPos==-1) {
                    zeroPos = currentPos;
                }
            } else {
                if (zeroPos!=-1) {
                    nums[zeroPos] = nums[currentPos];
                    nums[currentPos] = 0;
                    zeroPos = currentPos;
                }
            }
            currentPos++;
        }
    }

    public static void main(String[] args){
        String[] inputs = {"1 0 2 0 0 7", "3 1 0 1 3 8 9"};
        for(int i = 0; i < inputs.length; i++) {
            int[] arr = Arrays.stream(inputs[i].split(" ")).mapToInt(Integer::parseInt).toArray();
            MoveZerosToEnd.moveZeros(arr);
            System.out.println("Move zero :"+Arrays.stream(arr).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
        }
    }
}
