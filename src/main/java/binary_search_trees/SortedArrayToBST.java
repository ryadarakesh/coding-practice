package binary_search_trees;

import tress.BSTNode;

public class SortedArrayToBST {
    public static void main(String[] args) {
        BSTNode node = arrayToBST(new int[] {1,2,3,4,5},0,4);
        BSTUtis.printInOrder(node);
    }


    /*
    As we have to convert the sorted array to BST the middle element of sorted array need to be the root and lesser values should be in left and higher should be in right
    So we need to apply recursively the same approach
     */
    static BSTNode arrayToBST(int[] a, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        BSTNode root = new BSTNode(a[mid]);
        root.setLeft(arrayToBST(a, start, mid - 1));
        root.setRight(arrayToBST(a, mid + 1, end));
        return root;
    }
}
