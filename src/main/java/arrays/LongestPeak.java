package arrays;

public class LongestPeak {
    public static void main(String[] args) {
        System.out.println(longestPeak(new int[]{1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3}));
    }

    // returns an element that has before and after values as lesser and have more number of less valued followed values
    static String longestPeak(int a[]) {
        int peakEle = Integer.MIN_VALUE;
        int peakSize = 0;
        for (int i = 1; i < a.length - 1; i++) {
            // If value is peak of it's neibour then only it is elegible to be a peak
            if (a[i] > a[i - 1] && a[i] > a[i + 1]) {
                int peak = getPeakLength(a, i, a[i]);
                if (peak > peakSize) {
                    peakSize = peak;
                    peakEle = a[i];
                }
            }
        }

        return "Peak Ele - " + peakEle + "  , Peak Size -" + peakSize;
    }

    static int getPeakLength(int[] a, int startPos, int peakVal) {
        int len = 1;
        for (int i = startPos + 2; i < a.length; i++) {
            if (a[i] < peakVal) {
                len++;
            } else {
                return len;
            }
        }
        return len;
    }
}
