package binary_search_trees;

import tress.BSTNode;
import tress.BinaryTreeUtils;

public class PruneBST {
    public static void main(String[] args) {
        ThreadLocal<String> t = new ThreadLocal<>();
        t.set("t");
        BSTNode node = BinaryTreeUtils.createBST();
        BSTUtis.printInOrder(node);
        node = pruneBSt(node, 3, 7);
        BSTUtis.printInOrder(node);
    }

    // It removes elements < low and elements > high
    public static BSTNode pruneBSt (BSTNode node, int low, int high) {
        if (node == null) {
            return null;
        }
        // POST Order traversal
        node.setLeft(pruneBSt(node.getLeft(), low, high));
        node.setRight(pruneBSt(node.getRight(), low, high));
        if (node.getData() > low && node.getData() <high) {
            return node;
        }
        //
        if (node.getData() < low) {
            return node.getRight();
        } else if (node.getData() > high){
            return node.getLeft();
        }
        return node;
    }
}
