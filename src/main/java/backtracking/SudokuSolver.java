package backtracking;

public class SudokuSolver {

    public static void main(String[] args) {
        int grid[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

        if (solveSudoku(grid))
            print(grid);
        else
            System.out.println("No Solution exists");
    }

    public static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                // 0 means it is empty
                if (board[row][col] == 0) {
                    for (int val = 1; val <= board.length; val++) {
                        // Check whether value can be placed
                        if (isValidNumberForSlot(board, row, col, val)) {
                            // If val is allowed place it
                            board[row][col] = val;
                            // Check whether the placed value can lead to solution
                            if (solveSudoku(board)) {
                                return true;
                            } else {
                                // If placed value does not lead to solution clear it and place next possible value and continue checking
                                board[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isValidNumberForSlot(int[][] board, int row, int col, int number) {
        return isValidNumberForRow(board, row, number) && isValidNumberForCol(board, col, number)
                && isValidNumberForBox(board, row, col, number);
    }

    static boolean isValidNumberForRow(int[][] board, int row, int number) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == number) {
                return false;
            }
        }
        return true;
    }

    static boolean isValidNumberForCol(int[][] board, int col, int number) {
        for (int i = 0; i < board[0].length; i++) {
            if (board[i][col] == number) {
                return false;
            }
        }
        return true;
    }

    static boolean isValidNumberForBox(int[][] board, int row, int col, int number) {
        int sqrt = (int) Math.sqrt(board.length);
        int startRow = row - (row) % sqrt;
        int colStart = col - (col) % sqrt;
        for (int i = startRow; i < startRow + sqrt; i++) {
            for (int j = colStart; j < colStart + sqrt; j++) {
                if (board[i][j] == number) {
                    return false;
                }
            }
        }
        return true;
    }

    static void print(int[][] grid)
    {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++)
                System.out.print(grid[i][j] + " ");
            System.out.println();
        }
    }
}
