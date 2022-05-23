package arrays;

import java.util.Arrays;

public class SmallestDiffPair {
    public static void main(String[] args) {
        smallestDiffPair(new int[]{-1,5,10,20,28,3}, new int[]{26,134,135,15,17});
    }

    public static void smallestDiffPair(int[] a, int[] b) {
        int l = 0, r = 0;
        Arrays.sort(a);
        Arrays.sort(b);
        int diff = Integer.MAX_VALUE;
        while (l < a.length && r < b.length) {
            int currDiff = Math.abs(a[l] - b[r]);
            if (currDiff < diff) {
                diff = currDiff;
            }
            if (a[l] < b[r]) {
                l++;
            } else {
                r++;
            }
        }
        System.out.println("Smallest diff " + diff);
    }
}
