package backtracking;

import helpers.ArrayUtils;

public class NLengthBinaryStrings {
    static byte[] a = new byte[3];
    static int n=3;
    static int k =4;
    public static void main (String[] args) {
        //binary(0);
        knary(0);
    }

    /*
    Start from 0thy position place each possible option (Here 0/1) and recurse to fill remaining positions
     */
    private static void binary(int i) {
        if (i == n) {
            ArrayUtils.printElements(a);
        } else {
            a[i] = 0;
            binary(i+1);
            a[i] = 1;
            binary(i+1);
        }
    }

    /*
    Start from 0th position fill each postion with each possible value and recurse to fill remaining values with each possible values
     */
    private static void knary(int i) {
        if (i == n) {
            ArrayUtils.printElements(a);
        } else {
            for (int m=0; m< k; m++) {
                a[i] = (byte)m;
                knary(i + 1);
            }
        }
    }


}
