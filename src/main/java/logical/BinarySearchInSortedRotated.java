package logical;

public class BinarySearchInSortedRotated {
    static int binarySearchInSortedRotated(int array[], int start, int end, int value)
    {
        if (start>end) {
            return -1;
        }
        int mid = (start+end)/2;
        if (array[mid] == value) {
            return mid;
        }
        // mid element is greater than start means left side is completely ascending order
        // Otherwise rotation started before mid hence right side would be completely sorted
        // Hence we will get a chance to vlaidate once side atleast whether item can be there or not
        if (array[mid] >= array[start]) {
            if (array[start]<=value && array[mid]>value) {
                return binarySearchInSortedRotated(array, start, mid-1, value);
            } else {
                return binarySearchInSortedRotated(array, mid+1, end, value);
            }
        } else {
            if (array[mid]<value && array[end]>=value) {
                return binarySearchInSortedRotated(array, mid+1, end, value);
            } else {
                return binarySearchInSortedRotated(array, start, mid-1, value);
            }
        }
    }

    public static void main(String args[])
    {

        System.out.println("1 Should be found at 7 - "+ binarySearchInSortedRotated(new int[]{ 3,4, 5, 6, 7, 8, 9, 1, 2}, 0, 8, 1));

        System.out.println("3 Should be found at 8 - "+ binarySearchInSortedRotated(new int[]{5, 6, 7, 8, 9, 10, 1, 2, 3},0,8,3));

        System.out.println("28 Should not be found - "+ binarySearchInSortedRotated(new int[]{5, 6, 7, 8, 9, 10, 1, 2, 3},0,8,28));
    }

}
