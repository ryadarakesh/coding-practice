package helpers;

public class ArrayUtils {
    public static void reverseElements(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
    public static void printElements(int[] array) {
        for (int ele: array) {
            System.out.print(ele+"  ");
        }
    }

    public static void printElements(byte[] array) {
        for (byte ele: array) {
            System.out.print(ele+"  ");
        }
        System.out.println("");
    }
}
