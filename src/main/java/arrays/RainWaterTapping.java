package arrays;

public class RainWaterTapping {
    public static void main(String[] args) {
        System.out.println(trappingRainWater(new int[]{3,2,1,2,2,3,2}));
    }

    public static int trappingRainWater(int[] elevations) {
        int[] maxLeft = new int[elevations.length];
        int[] maxRight = new int[elevations.length];
        int max = elevations[0];
        maxLeft[0] = max;
        for (int i=1; i<elevations.length; i++) {
            maxLeft[i] = max;
            max = Math.max(elevations[i], max);
        }
        max = elevations[elevations.length-1];
        maxRight[elevations.length-1] = max;
        for (int i=elevations.length-2; i>=0; i--){
            maxRight[i] = max;
            max = Math.max(elevations[i], max);
        }
        int capacity =0;
        for (int j=1; j<elevations.length-1; j++) {
            int minBar = Math.min(maxLeft[j], maxRight[j]);
            if (minBar>elevations[j]) {
                capacity+=(minBar-elevations[j]);
            }
        }

        return capacity;
    }
}
