package logical;

import helpers.ArrayUtils;

public class Sort3NumbersDutchFlag {


    public static void main(String[] args) {
        int[] a = {1,0,1,2,1,1,0,2,2,1,0};
        dutchFlagSorting(a);
        ArrayUtils.printElements(a);
    }


    // Sort 0,1,2s using dutch flag method not counting
    // https://www.youtube.com/watch?v=srRqxjRA9dQ
    public static void dutchFlagSorting (int[] a) {
        int i=0, j=0, k=a.length-1;
        // Here j satys back to track left side ones where as i continues to search
        while (i<=k) {
            if (a[i]==0) {
                // Here J was tracking 1's in the left side so that if any zero's in right can be swapped
                swap(a, i , j);
                i++;
                j++;
            } else if (a[i] == 1) {
                // Just increment i because j need to track 1's for future swap if any zeros comes
                i++;
            } else {
                swap(a, k, i);
                k--;
                // here we should not increment i because 2 might come from right swap which need to be handled in next scan and compare with k-- position
            }
        }


    }

    static void swap (int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}
