package logical;

public class PeakElement {

    public static void main(String[] args) {
        System.out.println(peak(new int[]{1}, 0, 0));
        System.out.println(peak(new int[]{2, 8}, 0, 1));
        System.out.println(peak(new int[]{2, 8, 12,30, 5, 8}, 0, 5));
        System.out.println(peak(new int[]{2, 8, 12,30, 35, 40}, 0, 5));
        System.out.println(peak(new int[]{15, 13, 10, 5, 3, 2}, 0, 5));
    }

    static int peak(int[] a, int low, int high) {
        int mid = low + (high - low) / 2;
        if ((mid == 0 || a[mid] >= a[mid - 1]) && (mid == a.length - 1 || a[mid] >= a[mid + 1])) {
            return mid;
        } else if (mid > 0 && a[mid] < a[mid - 1]) {
            return peak(a, low, mid - 1);
        } else {
            return peak(a, mid + 1, high);
        }
    }
}
