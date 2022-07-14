package backtracking;

/*
Maze with a zero at position means blocked 1 means allowed
Rate cat travel 1 position forward or downward
 */
public class RatMaze {

    public static void main(String[] args) {
        solveRatMazeFromSt();
    }

    static class Movement {
        public int x_move;
        public int y_move;

        public Movement(int x_move, int y_move) {
            this.x_move = x_move;
            this.y_move = y_move;
        }
    }

    static Movement[] moves = new Movement[2];

    static {
        moves[0] = new Movement(1, 0);
        moves[1] = new Movement(0, 1);
    }

    public static void solveRatMazeFromSt() {
        int maze[][] = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}};
        int solution[][] = {{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}};
        solution[0][0] = 1;
        if (!solveRatMaze(0, 0, maze, solution)) {
            System.out.println("No Solution found!");
        } else {
            for (int i = 0; i < maze.length; i++) {
                for (int j = 0; j < maze.length; j++) {
                    System.out.print(" " + maze[i][j]);
                }
                System.out.println(" ");
            }
            System.out.println(" Solution");
            for (int i = 0; i < solution.length; i++) {
                for (int j = 0; j < solution.length; j++) {
                    System.out.print(" " + solution[i][j]);
                }
                System.out.println(" ");
            }
        }
    }

    public static boolean solveRatMaze(int x, int y, int[][] maze, int[][] solution) {
        if (x == maze.length - 1 && y == maze.length - 1 && maze[x][y] == 1) {
            return true;
        }
        for (int i = 0; i < moves.length; i++) {
            Movement m = moves[i];
            if (isMoveAllowed(x + m.x_move, y + m.y_move, maze)) {
                int x_new = x + m.x_move;
                int y_new = y + m.y_move;
                // If the path is alrady part of solution
                // In this case there is no back movement so this scenariois not possible
                if (solution[x_new][y_new] == 1) {
                    return false;
                }
                solution[x_new][y_new] = 1;
                if (solveRatMaze(x_new, y_new, maze, solution)) {
                    return true;
                } else {
                    solution[x_new][y_new] = 0;
                }
            }
        }
        return false;
    }

    public static boolean isMoveAllowed(int x, int y, int[][] maze) {
        if (x >= 0 && y >= 0 && x < maze.length && y < maze.length && maze[x][y] != 0) {
            return true;
        }
        return false;
    }

}
