package binary_search_trees;

import tress.BSTNode;

public class BSTUtis {
    public static BSTNode findMax (BSTNode node) {
        if (node == null) {
            return null;
        }
        if (node.getRight() == null) {
            return node;
        } else {
            return findMax(node.getRight());
        }
    }

    public static void printInOrder(BSTNode node) {
        System.out.println("\n");
        inOrder(node);
    }

    static void inOrder(BSTNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.getLeft());
        System.out.print(node.getData()+" ");
        inOrder(node.getRight());
    }
}
