package arrays;

public class SmallestSubArraySort {
    public static void main(String[] args) {
        smallestSubArraySort(new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19});
        smallestSubArraySort(new int[]{1, 2, 4, 3, 5, -1});
        smallestSubArraySort(new int[]{1, 2, 4, 3, 5, -1, 7, 10, -2});
        smallestSubArraySort(new int[]{1, 2, 3, 5, 7, 10});
    }

    static void smallestSubArraySort(int[] a) {
        int maxTillNow = a[0];
        int minEleUnsorted = Integer.MAX_VALUE;
        int outOfOrderEnds = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > maxTillNow) {
                maxTillNow = a[i];
            } else {
                if (minEleUnsorted > a[i]) {
                    minEleUnsorted = a[i];
                }
                outOfOrderEnds = i;
            }
        }
        if (outOfOrderEnds != 0) {

            System.out.println("sub array to sort (" + getSmallerPosThanIStarts(a, minEleUnsorted) + " ," + outOfOrderEnds + ")");
        } else {
            System.out.println("No Sort Required");
        }
    }

    static int getSmallerPosThanIStarts(int[] a, int ele) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= ele) {
                return i;
            }
        }
        return a.length;
    }
}
