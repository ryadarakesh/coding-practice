package backtracking;

public class KnightTour {

    public static void main(String[] args) {
        knightTourFromZeroPosition();
    }

    static int[] x_moves = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] y_moves = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void knightTourFromZeroPosition() {

        int[][] solution = new int[8][8];
        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution.length; j++) {
                solution[i][j] = -1;
            }
        }
        solution[0][0] = 0;
        if (!solveKnightProblem(0, 0, solution, 1)) {
            System.out.println("Solution is not possible!");
        } else {
            for (int i = 0; i < solution.length; i++) {
                for (int j = 0; j < solution.length; j++) {
                    System.out.print(" " + solution[i][j]);
                }
                System.out.println("");
            }

        }
    }

    static boolean isSafeMove(int x, int y, int[][] solutions) {
        // If x & y is in bounds and not already covered
        if (x >= 0 && y >= 0 && x < solutions.length && y < solutions.length && solutions[x][y] == -1) {
            return true;
        }
        return false;
    }

    public static boolean solveKnightProblem(int x, int y, int[][] solutions, int currentMove) {
        // All boxes covered
        if (currentMove == solutions.length * solutions.length) {
            return true;
        }
        // Try each alternate path if solution is found in that path return true else mark it as un bisited and search in new path
        for (int i = 0; i < x_moves.length; i++) {
            int x_new = x + x_moves[i];
            int y_new = y + y_moves[i];
            if (isSafeMove(x_new, y_new, solutions)) {
                solutions[x_new][y_new] = currentMove;
                if (solveKnightProblem(x_new, y_new, solutions, currentMove + 1)) {
                    return true;
                } else {
                    solutions[x_new][y_new] = -1;
                }
            }
        }
        return false;
    }

}
