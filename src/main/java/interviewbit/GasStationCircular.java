package interviewbit;

import java.util.Arrays;
import java.util.List;

/*
Given two integer arrays A and B of size N. There are N gas stations along a circular route, where the amount of gas at station i is A[i].

You have a car with an unlimited gas tank and it costs B[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the minimum starting gas station's index if you can travel around the circuit once, otherwise return -1.

You can only travel in one direction. i to i+1, i+2, ... n-1, 0, 1, 2.. Completing the circuit means starting at i and ending up at i again.


Input Format
The first argument given is the integer array A. The second argument given is the integer array B.


Output Format
Return the minimum starting gas station's index if you can travel around the circuit once, otherwise return -1.


Example Input
A = [1, 2] B = [2, 1]
 */
public class GasStationCircular {

    public static void main(String[] args) {
        GasStationCircular gas = new GasStationCircular();
        System.out.println(gas.canCompleteCircuit(Arrays.asList(6,3,7), Arrays.asList(4,6,3))); // start from 2
        System.out.println(gas.canCompleteCircuit(Arrays.asList(1,2), Arrays.asList(2,1)));
    }

    // A is Fuel available at station i and B is fuel needed to go from i to i+1
    // Returns the position from where it can complete full circle
    public int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {
        int availableCapacity = 0;
        int previousDeficit = 0;
        int start = 0;
        for (int i=0; i<A.size(); i++) {
            availableCapacity+= A.get(i) - B.get(i);
            // If available fuels is less than required fuel to go to next station
            if (availableCapacity<0) {
                // Reset stat point and place defict so that we need not to travel from 0 to i again
                previousDeficit = previousDeficit + availableCapacity; // It is actually adding deficit
                // This is to return in future as starting point if we are able to travel
                start = i+1;
                availableCapacity =0;
            }
        }
        if (availableCapacity+previousDeficit >= 0) {
            return start;
        }
        return -1;
    }
}

