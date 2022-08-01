package logical;

public class RainWaterStorage {

    public static void main(String[] args) {
        System.out.println(rainWaterStorageCapacity(new int[] {5,3,4,6,3,6}));
        System.out.println(rainWaterStorageCapacity(new int[] {3, 0, 2, 0, 4}));
        System.out.println(rainWaterStorageCapacity(new int[] {3, 0, 1, 0, 4}));


    }

    /*
    Here for each position we need to find the right most bar and left most bar
    And min of those to will impact the water capacity then we need to substract bar heigh from that will give capacity at that pos
    Here we are precalculating left mopst and right most for each postion and then calculating capacity at each postion
     */
    static int rainWaterStorageCapacity(int bars[]) {
        int leftMax[] = new int[bars.length];
        int righMax[] = new int[bars.length];
        int max = bars[0];
        leftMax[0] = max;
        for (int i = 1; i < bars.length; i++) {
            leftMax[i] = max;
            if (max < bars[i]) {
                max = bars[i];
            }
        }
        max = bars[bars.length - 1];
        righMax[bars.length - 1] = max;
        for (int i = bars.length - 2; i >= 0; i--) {
            righMax[i] = max;
            if (max < bars[i]) {
                max = bars[i];
            }
        }
        int capacity = 0;
        // Left and right most cannot hold any water
        for (int i = 1; i < bars.length - 1; i++) {
            if (Math.min(leftMax[i], righMax[i]) > bars[i]) {
                // Min of left and right bar minus the current bar height
                capacity += Math.min(leftMax[i], righMax[i]) - bars[i];
            }
        }
        return capacity;
    }
}
