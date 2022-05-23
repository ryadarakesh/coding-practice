package arrays;

import helpers.ArrayUtils;

public class MoveEleToEnd {
    public static void main(String[] args) {
        int a[] = new int[] {2,1,3,4,2,5,2,2};
        moveEleToEnd(a,2);
        ArrayUtils.printElements(a);
    }

    private static void moveEleToEnd (int[] a, int ele) {
        int l=0, r=a.length-1;
        while (l<r) {
            if (a[l] == ele && a[r] !=ele) {
                int temp = a[l];
                a[l] = a[r];
                a[r] = temp;
                l++; r--;
            } else if (a[l] != ele) {
                l++;
            } else if (a[r] == ele) {
                r--;
            }
        }
    }
}
