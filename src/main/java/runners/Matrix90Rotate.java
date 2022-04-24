package runners;

public class Matrix90Rotate {
    /**
     * Transpose the matrix then reverse row elements will give 90 degree rotation
     * @param args
     */
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3,4,17}, { 5, 6, 7, 8,18}, {9,10,11,12, 19}, {13,14,15,16,20}, {21,22,23,24,25}};
        display(matrix);
        transpose(matrix);
        reverseRows(matrix);
        System.out.println("Post rotate \n");
        display(matrix);
    }

    private static void transpose(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = i + 1; j < mat.length; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }

    private static void reverseRows(int[][] mat) {
        int len = mat.length - 1;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j <= len / 2; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][len - j];
                mat[i][len - j] = temp;
            }
        }
    }

    private static void display(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                System.out.print(mat[i][j] + "  ");
            }
            System.out.println("");
        }
    }
}
