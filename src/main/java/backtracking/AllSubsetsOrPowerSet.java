package backtracking;

import utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class AllSubsetsOrPowerSet {
    public static void main(String[] args) {
        List<List<Integer>> subsets = new ArrayList<>();
        ArrayList<Integer> currentSet = new ArrayList<>();
        findSubsets(subsets, new int[]{1,2,3}, currentSet, 0);
        for (List<Integer> list : subsets) {
            Utils.printIntListElements(list);
        }
    }
    /*
    Here we will start with zero position elements and add it to current set then call recursively to process from next postion
    once one vertical hierarcy is done we will be good with all sets starting with zeroth element
    Then we remove the zeroth element and start with 1st pos and do same thing
     */
    public static void findSubsets(List<List<Integer>> subsets, int[] nums, ArrayList<Integer> currentSet, int index) {
        subsets.add(new ArrayList<>(currentSet));
        for (int i=index; i<nums.length; i++) {
            currentSet.add(nums[i]);
            findSubsets(subsets, nums, currentSet, i+1);
            currentSet.remove(Integer.valueOf(nums[i]));
        }
    }
}
