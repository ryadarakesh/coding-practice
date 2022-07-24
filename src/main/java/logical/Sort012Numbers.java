package logical;

import helpers.ArrayUtils;

public class Sort012Numbers {
    public static void main(String[] args) {
        int[] a = {1,0,1,0,2,0,2,1,0};
        sort(a);
        ArrayUtils.printElements(a);
    }

    static void sort(int[] a) {
        int low = 0, mid = 0, high = a.length - 1;
        while (mid <= high) {
            if (a[mid] == 1) {
                // Should not increment 1 because low should hold start of zeros to swap with future zeros at mid
                mid++;
            } else if (a[mid] == 0) {
                int temp = a[mid];
                a[mid] = a[low];
                a[low] = temp;
                // we placed zero at low hence moving low
                low++;
                mid++;
            } else {
                int temp = a[high];
                a[high] = a[mid];
                a[mid] = temp;
                // Here we should not increment mid because 0 or 2 might come from end to mid position
                // If we increase mid will miss chance to sort it
                high--;
            }
        }
    }
}

