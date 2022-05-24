package arrays;

import java.util.Arrays;

public class TripletSum {
    public static void main(String[] args) {
        findTripletSum(new int[]{1, 2, 3, -4, -5, 8, 9, 10, 7}, 14);
        findTripletSum(new int[]{1, 2, 3, -4, -6, 8, 9, 10, 0}, 15);
        findTripletSum(new int[]{1, 2, 3, -4, -6, 8, 9, 10, 0}, 25);
    }

    // Start with 0th position of a sorted array as first element 1st and last s remaining based on sum requirements move first as last element
    public static void findTripletSum(int[] a, int sum) {
        Arrays.sort(a);
        boolean found = false;
        for (int i = 0; i < a.length - 3 && !found; i++) {
            int l = i + 1, r = a.length - 1;
            while (l < r) {
                int currSum = a[i] + a[l] + a[r];
                if (currSum == sum) {
                    System.out.println("Triplet Found : " + a[i] + ", " + a[l] + ", " + a[r]);
                    found = true;
                    break;
                } else if (currSum < sum) {
                    l++;
                } else {
                    r--;
                }

            }
        }
        if (!found)
            System.out.println("Not found");
    }
}
