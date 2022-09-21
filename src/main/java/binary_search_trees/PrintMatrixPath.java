package binary_search_trees;

import utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class PrintMatrixPath {
    static Move[] moves = null;

    public static void main(String[] args) {
        moves = new Move[2];
        moves[0] = new Move(0, 1);
        moves[1] = new Move(1,0);
        int mat[][] = { { 1, 2, 3 },
                { 4, 5, 6 } };
        List<Integer> list = new ArrayList<>();
        list.add(mat[0][0]);
        System.out.println(" 2X3 matrix");
        printAllPossibleMatrixPaths(mat, 0, 0, list);
        int mat1[][] = { { 1, 2, 3 },
                         { 4, 5, 6 },
                         { 7, 8, 9 } };
        list = new ArrayList<>();
        list.add(mat[0][0]);
        System.out.println(" 3X3 matrix");
        printAllPossibleMatrixPaths(mat1, 0, 0, list);
    }
    /*
    This should print all possible paths from (0,0) to (m-1,n-1)
     */

    private static void printAllPossibleMatrixPaths(int mat[][], int row, int col, List<Integer> list){
        if (row == mat.length-1 && col== mat[0].length-1) {
            printElementsInSameLine(list);
            return;
        }
        for (Move m: moves) {
           if (isMoveInMatrixLimits(row, col, m, mat)) {
               int matrixPosValue = mat[row+m.x_move][col+m.y_move];
               list.add(matrixPosValue);
               printAllPossibleMatrixPaths(mat, row+m.x_move, col+m.y_move, list);
               list.remove(Integer.valueOf(matrixPosValue));
           }
        }
    }

    static void printElementsInSameLine (List<Integer> list) {
        for (int i: list) {
            System.out.print(i+" ");
        }
        System.out.println("");
    }

    static boolean isMoveInMatrixLimits (int row, int col, Move move, int mat[][]) {
        return row+move.x_move < mat.length && col+move.y_move<mat[0].length;
    }

    static class Move {
        public int x_move;
        public int y_move;

        public Move(int x_move, int y_move) {
            this.x_move = x_move;
            this.y_move = y_move;
        }
    }
}
