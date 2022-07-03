package logical;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1, 3, 5, 7, 8, 10, 13, 15, 18}, 15, 0, 8));
        System.out.println(binarySearch(new int[]{1, 3, 5, 7, 8, 10, 13, 15, 18}, 3, 0, 8));
        System.out.println(binarySearch(new int[]{1, 3, 5, 7, 8, 10, 13, 15, 18}, 28, 0, 8));
    }

    public static int binarySearch(int[] a, int ele, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (a[mid] == ele) {
            return mid;
        } else if (a[mid] < ele) {
            return binarySearch(a, ele, mid + 1, end);
        } else {
            return binarySearch(a, ele, start, mid - 1);
        }
    }
}
