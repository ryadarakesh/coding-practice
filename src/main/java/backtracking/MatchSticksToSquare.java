package backtracking;

import helpers.ArrayUtils;

import java.util.Arrays;

public class MatchSticksToSquare {

    public static void main(String[] args) {
        MatchSticksToSquare square = new MatchSticksToSquare();
        System.out.println(square.makesquare(new int[] {1,1,2,2,2}));
        System.out.println(square.makesquare(new int[] {3,3,3,3,4}));
    }

    public boolean makesquare(int[] sticks) {
        int sum = Arrays.stream(sticks).sum();
        if (sum % 4 != 0) {
            return false;
        }
        int side = sum / 4;
        int[] sides = new int[4];
        sides[0] = side;
        sides[1] = side;
        sides[2] = side;
        sides[3] = side;
        Arrays.sort(sticks);
        ArrayUtils.reverseElements(sticks, 0, sticks.length-1);
        return checkForSquare(sticks, sides, 0);
    }

    public boolean checkForSquare(int[] sticks, int[] sides, int i) {
        if (i == sticks.length) {
            if (sides[0] == 0 && sides[1] == 0 && sides[2] == 0 && sides[3] == 0) {
                return true;
            }
            return false;
        }
        for (int j = 0; j < sides.length; j++) {
            if (sticks[i] <= sides[j]) {
                sides[j] = sides[j] - sticks[i];
                // Place each stick at some side and go for next stick and at the end check whether it formed a square
                // else revert it and place it in next side
                if (checkForSquare(sticks, sides, i + 1)) {
                    return true;
                }
                sides[j] = sides[j] + sticks[i];
            }
        }
        return false;
    }


}
