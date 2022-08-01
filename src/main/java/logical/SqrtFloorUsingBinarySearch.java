package logical;

public class SqrtFloorUsingBinarySearch {
    public static void main(String[] args) {
        System.out.println("SQRT of 64 - "+ sqrtBinarySearch(64, 0, 64));
        System.out.println("SQRT of 65 - "+ sqrtBinarySearch(65, 0, 65));
        System.out.println("SQRT of 11 - "+ sqrtBinarySearch(11, 0, 11));
        System.out.println("SQRT of 17 - "+ sqrtBinarySearch(17, 0, 17));
    }

    static int sqrtBinarySearch (int n, int start , int end) {
        if (start>end) {
            return end;
        }
        int mid = (start+end)/2;
        if (mid*mid == n) {
            return mid;
        }
        if (mid*mid > n) {
            return sqrtBinarySearch (n, start, mid-1);
        } else {
            return sqrtBinarySearch (n, mid+1, end);
        }
    }
}
