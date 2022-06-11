package binary_search_trees;

import tress.BSTNode;
import tress.BinaryTreeUtils;

public class BSTInsertion {
    public static void main(String[] args) {
        BSTNode node = BinaryTreeUtils.createBST();
        BinaryTreeUtils.printElementsInLevelOrder(node);
        insert(node, 1);
        insert(node,10);
        insert(node,7);
        System.out.println("\n ");
        BinaryTreeUtils.printElementsInLevelOrder(node);

        System.out.println("\n Max Elelement - "+BSTUtis.findMax(node).getData());
    }

    static BSTNode insert(BSTNode node, int element) {
        if (node == null) {
            return new BSTNode(element);
        }
        if (node.getData() > element) {
            node.setLeft(insert(node.getLeft(), element));
        } else {
            node.setRight(insert(node.getRight(), element));
        }
        return node;
    }


}
