package arrays;

import java.util.HashSet;
import java.util.Set;

/*
9X9 sudoku
 */
public class ValidateSudoku {

    public static boolean isValidSudoku(char[][] board) {
    // Check rows
        for (int row = 0; row < 9; row++) {
            if (!isValidRow(board, row)) {
                return false;
            }
        }

        // Check cols
        for (int col = 0; col < 9; col++) {
            if (!isValidCol(board, col)) {
                return false;
            }
        }

        // Check boxes
        // Here we are incrementing row and column by 3
        for (int row = 0; row < 9; row=row+3) {
            for (int col = 0; col < 9; col = col + 3) {
                if (!isValidBox(board, row, col)) {
                    return false;
                }
            }
        }
        return true;

    }

    static boolean isValidRow(char[][] board, int row) {
        Set<Character> set = new HashSet<>();
        for (int col = 0; col < 9; col++) {
            char ch = board[row][col];
            if (set.contains(ch)) {
                return false;
            }
            if ('.' != ch) {
                set.add(ch);
            }
        }
        return true;
    }

    static boolean isValidCol(char[][] board, int col) {
        Set<Character> set = new HashSet<>();
        for (int row = 0; row < 9; row++) {
            char ch = board[row][col];
            if (set.contains(ch)) {
                return false;
            }
            if ('.' != ch) {
                set.add(ch);
            }
        }
        return true;
    }

    static boolean isValidBox(char[][] board, int rowStart, int colStart) {
        Set<Character> set = new HashSet<>();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                char ch = board[rowStart + row][colStart + col];
                if (set.contains(ch)) {
                    return false;
                }
                if ('.' != ch) {
                    set.add(ch);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][] {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };

        // Function call
        System.out.println(
                (isValidSudoku(board) ? "YES" : "NO"));

        board = new char[][] {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '9', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };

        // Function call
        System.out.println(
                (isValidSudoku(board) ? "YES" : "NO"));
    }
}
