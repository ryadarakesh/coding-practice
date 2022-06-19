package avl_trees;

import tress.BSTNode;
import tress.BTNode;

public class AVLTreeUtils {

    public static AVLNode singleLLRotation(AVLNode root) {
        AVLNode newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;
        return newRoot;
    }

    public static AVLNode singleRRRotation(AVLNode root) {
        AVLNode newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;
        return newRoot;
    }

    public static AVLNode doubleLRRotation(AVLNode root) {
        root.setLeft(singleRRRotation(root.left));
        return singleLLRotation(root);
    }

    public static AVLNode doubleRLRotation(AVLNode root) {
        root.setRight(singleLLRotation(root.right));
        return singleRRRotation(root);
    }

    public static int height(AVLNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    static void printInOrder(AVLNode node) {
        if (node == null) {
            return;
        }
        printInOrder(node.getLeft());
        System.out.print(node.getData()+" ");
        printInOrder(node.getRight());
    }

    static boolean isAVLTree(AVLNode node) {
        if (node == null) {
            return true;
        }
        if ((node.left != null && node.data < node.left.data) || (node.right != null && node.data > node.right.data)) {
            return false;
        }
        if (Math.abs(AVLTreeUtils.height(node.left) - AVLTreeUtils.height(node.right)) >= 2) {
            return false;
        }
        return isAVLTree(node.left) && isAVLTree(node.right);
    }
}
