package avl_trees;

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

}
