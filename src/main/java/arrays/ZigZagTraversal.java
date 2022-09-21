package arrays;

public class ZigZagTraversal {

    public static void main(String[] args) {
        zigZagTraverse(new int[][] {
                {1,3,4,10},
                {2,5,9,11},
                {6,8,12,15},
                {7,13,14,16}});
    }
    static void zigZagTraverse(int a[][]) {
        int row =0;
        int col =0;
        System.out.print(a[row][col]+" ");
        while (row >=0 && row<a.length && col>=0 && col<a[0].length) {
            // Vertical Down
            if (row+1<a.length) {
                System.out.print(a[++row][col]+" ");
            } else if (col+1<a[0].length) {
                System.out.print(a[row][++col]+" ");
            }
            // Cross Up
            while (row-1>=0 && col+1<a[0].length) {
                System.out.print(a[--row][++col]+" ");
            }
            // Horizontal right
            if (col+1<a[0].length) {
                System.out.print(a[row][++col]+" ");
            } else if (row+1 < a.length) {
                System.out.print(a[++row][col]+" ");
            }
            // Cross down
            while (row+1<a.length && col-1>=0) {
                System.out.print(a[++row][--col]+" ");
            }
            if (row == a.length && col==a[0].length) {
                break;
            }
        }
    }
}
