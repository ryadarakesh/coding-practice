package runners;

import helpers.ArrayUtils;

import java.util.ArrayList;

public class ArrayRotateRunner {
    public static void main(String[] args) {
        rotate(new int[]{1, 2, 3, 4, 5, 6, 7},3);
    }

    // Left rotate elements by mentioned positions
    // First reverse entire array then reverse from start to len-shifts-1 and len-shifts to end
    private static void rotate(int[] array, int posToShift) {
        System.out.println("Before Rotation:");
        ArrayUtils.printElements(array);
        ArrayUtils.reverseElements(array, 0, array.length-1);

        ArrayUtils.reverseElements(array,0, array.length-posToShift-1);

        ArrayUtils.reverseElements(array,array.length-posToShift, array.length-1);

        System.out.println("\nAfter Rotation of "+posToShift);
        ArrayUtils.printElements(array);

        new ArrayList<>().add(5,"1");
    }
}
