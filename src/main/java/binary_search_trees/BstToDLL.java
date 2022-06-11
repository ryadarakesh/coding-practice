package binary_search_trees;

import linkedLists.LinkedListUtils;
import tress.BSTNode;
import tress.BinaryTreeUtils;

public class BstToDLL {
    public static void main(String[] args) {
        BSTNode node = BinaryTreeUtils.createBST();
        convertBSTToDLL(node);
        System.out.println("Print");
        BSTNode curr = head;
        while (curr != null) {
            System.out.print(curr.getData()+" ");
            curr = curr.getRight();
        }

    }

    static BSTNode head = null;
    static BSTNode prev = null;

    /*
    As we are travelling in In Order whenever we encounter data we need to treat it as next DLL node
    So at every step the prev stp need to be updated to tack the just processed node
    while processing first node we need to update head
     */
    static void convertBSTToDLL (BSTNode node) {
        if (node == null) {
            return ;
        }
        convertBSTToDLL(node.getLeft());
        // If it is first node in In order
        if (prev == null) {
            head = node;
        } else {
            node.setLeft(prev);
            prev.setRight(node);
        }
        prev = node;
        convertBSTToDLL(node.getRight());
    }
}
