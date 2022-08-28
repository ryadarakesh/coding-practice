package binary_search_trees;

import tress.BSTNode;
import tress.BinaryTreeUtils;

public class KthSmallest {
static int counter = 0;
    public static void main(String[] args) {
        BSTNode node = BinaryTreeUtils.createBST();
        BSTUtis.printInOrder(node);
        BSTNode kthSmall = kthSmallest(node, 3);
        System.out.println("Kth Smallest -" + kthSmall.getData());
        counter = 0;
        kthSmall = kthSmallest(node, 5);
        System.out.println("Kth Smallest -" + kthSmall.getData());
    }

    static BSTNode kthSmallest(BSTNode node, int k) {
        if (node == null) {
            return null;
        }
        BSTNode left = kthSmallest(node.getLeft(),k);
        // As below line 26 returns non null only when counter reaches we can return from recusion when left value is non null means we found answer
        // and need nto to check roo and right
        if (left != null) {
            return left;
        }

        // If root found the counter element need not to search in right hence returning
        if ( ++counter == k) {
            return node;
        }
        return kthSmallest(node.getRight(), k);

    }
}
