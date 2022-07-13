package java_practice;

import java.util.HashMap;
import java.util.Map;

public class Codility2 {
    public static void main(String[] args) {
        Codility2 cd2 = new Codility2();
        System.out.println(cd2.solution(new int[]{4,5}, 4,0,9));
    }

    public int solution(int[] A, int X, int Y, int Z) {
        int maxWaitTime = 0;
        Map<String, Integer> servingTimes = new HashMap();
        for (int i = 0; i < A.length; i++) {
            int waitingTime = 0;
            String availableDispenser = getRightDispenser(A[i], X, Y, Z);
            if ("".equals(availableDispenser)) {
                return -1;
            } else if ("X".equals(availableDispenser)) {
                X = X - A[i];
                waitingTime = servingTimes.getOrDefault("X", 0);
                servingTimes.put("X", waitingTime + A[i]);
            } else if ("Y".equals(availableDispenser)) {
                Y = Y - A[i];
                waitingTime = servingTimes.getOrDefault("Y", 0);
                servingTimes.put("Y", waitingTime + A[i]);
            } else if ("Z".equals(availableDispenser)) {
                Z = Z - A[i];
                waitingTime = servingTimes.getOrDefault("Z", 0);
                servingTimes.put("Z", waitingTime + A[i]);
            }
            if (maxWaitTime<waitingTime) {
                maxWaitTime = waitingTime;
            }
        }

        return maxWaitTime;
    }

    public String getRightDispenser(int required, int X, int Y, int Z) {
        int minFound = Integer.MAX_VALUE;
        String bunkFound = "";
        if (required <= X) {
            minFound = X;
            bunkFound = "X";
        }
        if (required <= Y && Y < minFound) {
            minFound = Y;
            bunkFound = "Y";
        }
        if (required <= Z && Z < minFound) {
            bunkFound = "Z";
        }
        return bunkFound;
    }

}

