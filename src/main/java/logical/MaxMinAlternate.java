package logical;

import helpers.ArrayUtils;

public class MaxMinAlternate {
    /*
     Input arr[] = {1,2,3,4,5,6}
            6,2,3,4,5,1
            6,1,3,4,5,2
        Output: 6 1 5 2 4 3
     */
    public static void main(String[] args) {
        int[] res = alternateMaxMin(new int[] {1,2,3,4,5,6,7,8,9});
        ArrayUtils.printElements(res);
    }

    static int[] alternateMaxMin (int[] a) {
        int b[] = new int[a.length];
        int i=0, j=a.length-1;
        int k=0;
        while (i<=j) {
            // Copy max ele from back
            b[k++] = a[j--];
            // copy min from front
            if (i<=j) {
                b[k++] = a[i++];
            }
        }
        return b;
    }

}
