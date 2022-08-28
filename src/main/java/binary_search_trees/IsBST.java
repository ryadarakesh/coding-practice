package binary_search_trees;

import tress.BSTNode;
import tress.BinaryTreeUtils;

public class IsBST {

    public static void main(String[] args) {
        BSTNode node = BinaryTreeUtils.createBStNodeWithLeftAndRightNode(6, 2, 8);
        node.getLeft().setLeft(new BSTNode(1));
        node.getLeft().setRight(new BSTNode(9));
        BSTUtis.printInOrder(node);
        System.out.println("\n");
        System.out.println("IS BST - " + isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE));
        node.getLeft().getRight().setData(5);
        System.out.println("IS BST - " + isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    /*
        Here we are checking whether the left sub tree is within some min and root.data and right sub tree is within root.data nad some max

        Alternately we can do the in order traversal and keep tracking whether root data value is less than already visited max value
     */
    public static boolean isBST(BSTNode node, int min, int max) {
        if (node == null) {
            return true;
        }
        return node.getData() > min && node.getData() < max && isBST(node.getLeft(), min, node.getData()) && isBST(node.getRight(), node.getData(), max);
    }

    
}
