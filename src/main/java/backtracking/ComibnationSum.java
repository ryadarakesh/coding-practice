package backtracking;

import java.util.ArrayList;

/*
Different combinations to achieve given sum
 */

public class ComibnationSum {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(6);
        list.add(8);
        System.out.println("Combinations for 8");
        printData(combinationSum(list, 8));
        System.out.println("Combinations for 12");
        printData(combinationSum(list, 12));
    }

    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> arr, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        combinationSum(result, arr, new ArrayList<>(), sum, 0);
        return result;
    }

    static void combinationSum (ArrayList<ArrayList<Integer>> result , ArrayList<Integer> arr,
                                ArrayList<Integer> currList, int sum, int index) {
        if (sum==0) {
            result.add(new ArrayList<>(currList));
            return;
        }
        for (int i=index; i<arr.size(); i++) {
            if (arr.get(i) <= sum) {
                currList.add(arr.get(i));
                combinationSum(result,arr,currList, sum-arr.get(i), i);
                currList.remove(arr.get(i));
            }
        }
    }

    static void printData (ArrayList<ArrayList<Integer>> result) {
        for (ArrayList<Integer> data : result) {
            for (Integer num : data) {
                System.out.print(" "+num+" ,");
            }
            System.out.println(" ");
        }
    }
}
