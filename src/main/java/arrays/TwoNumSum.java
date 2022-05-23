package arrays;

import java.util.Arrays;

public class TwoNumSum {
    public static void main(String[] args) {
        findTwoPosSum(new int[]{1,2,3,-4,-5,8,9,10},10);
        findTwoPosSum(new int[]{1,2,3,-4,-6,8,9,10},5);
    }

    public static void findTwoPosSum(int[] a, int sum) {
        Arrays.sort(a);
        int l = 0, r=a.length-1;
        while (l<r) {
           if (a[l]+a[r]==sum) {
               System.out.println("Found pair("+a[l]+","+a[r]+")");
               return;
           } else if(a[l]+a[r] < sum) {
               l++;
           } else {
               r--;
           }

        }
        System.out.println("Not found");
    }
}
