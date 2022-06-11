package binary_search_trees;

import tress.BSTNode;
import tress.BinaryTreeUtils;

public class BSTDeletion {
    public static void main(String[] args) {
        BSTNode tree = BinaryTreeUtils.createBST();
        BSTUtis.printInOrder(tree);
        tree = delete(tree, 2);
        tree = delete(tree, 8);
        BSTUtis.printInOrder(tree);
    }

    static BSTNode delete(BSTNode node, int ele) {
        if (node == null) {
            return null;
        }
        if (node.getData() > ele) {
            node.setLeft(delete(node.getLeft(), ele));
        } else if (node.getData() < ele) {
            node.setRight(delete(node.getRight(), ele));
        } else {
            if (node.getRight() != null && node.getLeft() != null) {
                BSTNode maxLeft = BSTUtis.findMax(node.getLeft());
                node.setData(maxLeft.getData());
                delete(node.getLeft(), maxLeft.getData());
                return node;
            } else if (node.getLeft() == null) {
                return node.getRight();
            } else {
                return node.getLeft();
            }
        }
        return node;
    }
}
