package tress;

import java.util.LinkedList;
import java.util.Queue;

public class TreeDepthWithLevelOrder {

    public static void main(String[] args) {
        BTNode node = BinaryTreeUtils.createSimpleBinaryTree();
        System.out.println(" Level order traversal");
        BinaryTreeUtils.printElementsInLevelOrder(node);
        System.out.println("Depth - " + depthWithLevelOrder(node));
        node.getLeft().getRight().getLeft().setRight(BinaryTreeUtils.createNodeWithLeftAndRightNode(40,41,42));
        System.out.println(" Level order traversal");
        BinaryTreeUtils.printElementsInLevelOrder(node);
        System.out.println("Depth "+ depthWithLevelOrder(node));
    }

    static int depthWithLevelOrder(BTNode node) {
        if (node == null) {
            return 0;
        }
        Queue<BTNode> queue = new LinkedList<>();
        int depth = 0;
        queue.add(node);
        // Adding null after root will enable us to identify the completion of the level
        // whenever we found null we need to increment deptCounter as long as queue is not empty
        queue.add(null);
        while (!queue.isEmpty()) {
            BTNode temp = queue.remove();
            if (temp == null) {
                depth++;
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            } else {
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }

        }
        return depth;
    }
}
