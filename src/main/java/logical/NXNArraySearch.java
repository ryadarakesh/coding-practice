package logical;

/**
 * Give an n × n array of elements such that each row is in ascending order and
 * each column is in ascending order, devise an O(n) algorithm to determine if a given
 * element x is in the array. You may assume all elements in the n × n array are distinct.
 */
public class NXNArraySearch {

    public static void main(String[] args) {
        int[][] a = new int[][] {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        System.out.println(search(a, 15));
        System.out.println(search(a, 23));
        System.out.println(search(a, 29));
    }
    public static boolean search (int[][] a, int target) {
        // start with 0th row and last column and if less value needed reduce col and else increase row
        int row=0, col=a.length-1;
        while (row<a.length && col>=0) {
            if (a[row][col]==target) {
                System.out.println("Found at ("+row+","+col+")");
                return true;
            } else if (a[row][col]<target){
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}
