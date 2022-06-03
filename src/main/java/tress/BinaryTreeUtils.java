package tress;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeUtils {
    public static BTNode createNodeWithLeftAndRightNode(int data, int left, int right) {
        BTNode node = new BTNode(data);
        node.setLeft(new BTNode(left));
        node.setRight(new BTNode(right));
        return node;
    }

    public static BTNode createSimpleBinaryTree() {
        BTNode root = BinaryTreeUtils.createNodeWithLeftAndRightNode(1, 2, 3);
        root.getLeft().setLeft(BinaryTreeUtils.createNodeWithLeftAndRightNode(4, 8, 9));
        root.getLeft().setRight(BinaryTreeUtils.createNodeWithLeftAndRightNode(5, 10, 11));
        root.getRight().setLeft(BinaryTreeUtils.createNodeWithLeftAndRightNode(6, 12, 13));
        root.getRight().setRight(BinaryTreeUtils.createNodeWithLeftAndRightNode(7, 14, 15));
        return root;
    }

    public static void printElementsInLevelOrder(BTNode node) {
        Queue<BTNode> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            BTNode curr = q.remove();
            System.out.print(curr.getData()+" ");
            if (curr.getLeft() != null) {
                q.add(curr.getLeft());
            }
            if (curr.getRight() != null) {
                q.add(curr.getRight());
            }
        }
    }
}
