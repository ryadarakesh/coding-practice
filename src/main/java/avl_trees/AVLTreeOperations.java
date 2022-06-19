package avl_trees;

public class AVLTreeOperations {
    public static void main(String[] args) {
        AVLNode root = insert(null, 1);
        root = insert(root, 2);
        root = insert(root,5);
        root = insert(root,4);
        root = insert(root,3);
        System.out.println(" In Order ");
        AVLTreeUtils.printInOrder(root);
        System.out.println(" \n Tree Height "+AVLTreeUtils.height(root));
        System.out.println("IS AVL Tree - "+AVLTreeUtils.isAVLTree(root));
        root = insert(root,0);
        root = insert(root,7);
        root = insert(root,9);
        root = insert(root,8);
        AVLTreeUtils.printInOrder(root);
        System.out.println(" \n Tree Height "+AVLTreeUtils.height(root));
        System.out.println("IS AVL Tree - "+AVLTreeUtils.isAVLTree(root));
        root = insert(root,12);
        root = insert(root,15);
        root = insert(root,20);
        AVLTreeUtils.printInOrder(root);
        System.out.println(" \n Tree Height "+AVLTreeUtils.height(root));
        System.out.println("IS AVL Tree - "+AVLTreeUtils.isAVLTree(root));
        root.getLeft().getLeft().getLeft().setLeft(new AVLNode(25));
        root.getLeft().getLeft().getLeft().getLeft().setLeft(new AVLNode(26));
        // SHould be false
        System.out.println("IS AVL Tree - "+AVLTreeUtils.isAVLTree(root));

    }

    public static AVLNode insert(AVLNode root, int data) {
        if (root == null) {
            return new AVLNode(data);
        }
        if (root.data > data) {
            root.setLeft(insert(root.getLeft(), data));
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
            root.setRight(insert(root.getRight(), data));
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
