package arrays;

public class SpiralPrintMatrix {

    public static void main(String[] args) {
        int a[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        // Function Call
        printSpiral(a);
    }

    static void printSpiral(int a[][]) {
        int sRow = 0, sCol = 0, eRow = a.length - 1, eCol = a[0].length - 1;
        while (sRow <= eRow && sCol <= eCol) {

            // Iterate Top row of remaining
            for (int i = sCol; i <= eCol; i++) {
                System.out.print(" " + a[sRow][i]);
            }
            sRow++;

            // Iterate End Col of remaining
            for (int i = sRow; i <= eRow; i++) {
                System.out.print(" " + a[i][eCol]);
            }
            eCol--;

            // Iterate End row in reverse direction
            for (int i = eCol; i >= sCol; i--) {
                System.out.print(" " + a[eRow][i]);
            }
            eRow--;

            // Iterate Start col in reverse order
            for (int i = eRow; i >= sRow; i--) {
                System.out.print(" " + a[i][sCol]);
            }
            sCol++;

        }
    }
}
