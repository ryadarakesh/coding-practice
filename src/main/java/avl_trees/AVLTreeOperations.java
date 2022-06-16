package avl_trees;

public class AVLTreeOperations {

    public AVLNode insert(AVLNode root, int data) {
        if (root == null) {
            return new AVLNode(data);
        }
        if (root.data < data) {
            root.setRight(insert(root.getRight(), data));
            if (AVLTreeUtils.height(root.getLeft()) - AVLTreeUtils.height(root.getRight()) == 2) {
                // LL Rotation
                if (data < root.getLeft().getData()) {
                    root = AVLTreeUtils.singleLLRotation(root);
                } else {
                    // LR rotation
                    root.setLeft(AVLTreeUtils.singleRRRotation(root.getLeft()));
                    root = AVLTreeUtils.singleLLRotation(root);
                }
            }
        } else {
            root.setLeft(insert(root.getLeft(), data));
            if (AVLTreeUtils.height(root.getRight()) - AVLTreeUtils.height(root.getLeft()) == 2) {
                // RR Rotation
                if (data > root.getRight().getData()) {
                    root = AVLTreeUtils.singleRRRotation(root);
                } else {
                    // RL rotation
                    root.setRight(AVLTreeUtils.singleLLRotation(root.getRight()));
                    root = AVLTreeUtils.singleRRRotation(root);
                }
            }
        }
        return root;
    }
}
