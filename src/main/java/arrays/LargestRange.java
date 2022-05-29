package arrays;

import java.util.HashMap;
import java.util.Map;

public class LargestRange {
    // It is to find max range in array which is consecutive
    public static void main(String[] args) {
        largestRange(new int[]{1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6});
        largestRange(new int[]{1, 11, 3, 0, 15, 2, 4, 10, 7, 12, 6});
        largestRange(new int[]{1, 20, 3, 27, 15, 25, 29, 10, 8, 12, 6});
    }

    static Map<Integer, Boolean> numberMap;

    /*Easiest way is to solve by sorting but will lead to O(nlogn) with hash map we can achive in O(n)
      Here we place all ele in Hash Map then for each number find lower range and upper range and if it is max range update.
      If elemet alreay visited means already its range is calculated
    * */
    static void largestRange(int[] a) {
        int resultStart = a[0];
        int resultEnd = a[0];
        int rangeStart;
        int rangeEnd;
        numberMap = new HashMap<>();
        for (int num : a) {
            numberMap.put(num, false);
        }
        for (int num : a) {
            if (numberMap.containsKey(num) && !numberMap.get(num)) {
                numberMap.put(num, true);
                rangeStart = getLeastNumExists(a, num);
                rangeEnd = getMaxNumExists(a, num);
                if ((resultEnd - resultStart) < (rangeEnd - rangeStart)) {
                    resultEnd = rangeEnd;
                    resultStart = rangeStart;
                }
            }
        }

        System.out.println("[" + resultStart + "," + resultEnd + "]");
    }

    static int getLeastNumExists(int[] a, int numToCheck) {
        while (numberMap.containsKey(numToCheck - 1)) {
            --numToCheck;
            numberMap.put(numToCheck, true);
        }
        return numToCheck;

    }

    static int getMaxNumExists(int[] a, int numToCheck) {
        while (numberMap.containsKey(numToCheck + 1)) {
            numToCheck++;
            numberMap.put(numToCheck, true);
        }
        return numToCheck;
    }

}


