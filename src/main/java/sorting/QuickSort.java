package sorting;

import helpers.ArrayUtils;

public class QuickSort {

    public static void main(String[] args) {
        int[] a = {15,1,19,3,8,7,6,2,20,12,16};
        quickSort(a, 0, a.length - 1);
        ArrayUtils.printElements(a);
    }

    public static void quickSort(int[] a, int start, int end) {
        if (start > end) {
            return;
        }
        int pivot = partitionByPlacingFirstElementInRightPosition(a, start, end);
        quickSort(a, start, pivot - 1);
        quickSort(a, pivot + 1, end);
    }

    /*
     For finding right position for splitting we pick first element of the partition and try to place it in right position and return its position
     Until start < end we mov left to right vice versa to find correct position for pivot which is first element then place it in right position which is right after the looping is done
     */
    public static int partitionByPlacingFirstElementInRightPosition(int[] a, int start, int end) {
        int pivot = a[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (left<=end && a[left] <= pivot) {
                left++;
            }
            while (right >= start && a[right] > pivot) {
                right--;
            }
            if (left < right) {
                swap(a, left, right);
            }
        }
        a[start] = a[right];
        a[right] = pivot;
        return right;
    }

    public static void swap(int[] a, int left, int right) {
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }
}
