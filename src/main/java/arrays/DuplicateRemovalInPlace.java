package arrays;

import helpers.ArrayUtils;

import java.util.Arrays;

public class DuplicateRemovalInPlace {
    public static void main(String[] args) {
        ArrayUtils.printElements(removeDups(new int[] {1,2,2,3,4,4,4,5,5}));
    }

    public static int[] removeDups(int[] a) {
        int j = 0;
        int i = 0;
        while (i < a.length - 1) {
            if (a[i] == a[i + 1]) {
                i++;
            } else {
                a[j++] = a[i++];
            }
        }
        a[j++] = a[i];
        return Arrays.copyOf(a, j);
    }

}
