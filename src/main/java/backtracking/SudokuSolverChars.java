package backtracking;

import java.util.Arrays;
import java.util.List;

public class SudokuSolverChars {

    static List<Character> values;


    public void solveSudoku(char[][] board) {
        values = Arrays.asList('1','2','3','4','5','6','7','8','9');
        solveSudokuGame(board);
    }

    public static boolean solveSudokuGame(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                // 0 means it is empty
                if (board[row][col] == '.') {
                    for (char val : values) {
                        // Check whether value can be placed
                        if (isValidNumberForSlot(board, row, col, val)) {
                            // If val is allowed place it
                            board[row][col] = val;
                            // Check whether the placed value can lead to solution
                            if (solveSudokuGame(board)) {
                                return true;
                            } else {
                                // If placed value does not lead to solution clear it and place next possible value and continue checking
                                board[row][col] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }


    static boolean isValidNumberForSlot(char[][] board, int row, int col, char number) {
        return isValidNumberForRow(board, row, number) && isValidNumberForCol(board, col, number)
                && isValidNumberForBox(board, row, col, number);
    }

    static boolean isValidNumberForRow(char[][] board, int row, char number) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == number) {
                return false;
            }
        }
        return true;
    }

    static boolean isValidNumberForCol(char[][] board, int col, char number) {
        for (int i = 0; i < board[0].length; i++) {
            if (board[i][col] == number) {
                return false;
            }
        }
        return true;
    }

    static boolean isValidNumberForBox(char[][] board, int row, int col, char number) {
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
}
