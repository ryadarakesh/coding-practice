package greedy_dp;

import java.util.Arrays;

public class MaxRailwayPlatforms {

    public static void main(String[] args) {
        int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
        int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
        System.out.println("Minimum Number of Platforms Required = "
                + getMaxPlatformsRequired(arr, dep));
    }
/*
Sort Arrival and Departures in order. Initialize platformes needed as 1 and start from arrival po 1 and depart pos0
for each arrival if arrival is <= departure increment platforms and go to next arrival.
If departure is less than arrival mean decrement platforms as one train left and move to next departure
 */
    public static int getMaxPlatformsRequired (int[] arrival, int[] depart) {
        Arrays.sort(arrival);
        Arrays.sort(depart);
        int i=1;
        int j=0;
        int result=1;
        int n=arrival.length;
        int platformsNeeded=1;
        while (i<n && j<n) {
            if (arrival[i] <= depart[j]) {
                platformsNeeded++;
                i++;
            } else if (arrival[i]>depart[j]){
                platformsNeeded--;
                j++;
            }
            if (result<platformsNeeded) {
                result = platformsNeeded;
            }
        }

        return result;
    }
}
