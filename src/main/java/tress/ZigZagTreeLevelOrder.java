package tress;

import java.util.*;

public class ZigZagTreeLevelOrder {

    public static void main(String[] args) {
        BTNode root = BinaryTreeUtils.createSimpleBinaryTree();
        /*List<Integer> result = levelOrderTraversal(root);
        result.stream().forEach(System.out::println);*/

        List<List<BTNode>> res = zigZagLevelOrder(root);
        System.out.println(res);
    }
    // Here we do like normal level order traversal but use an extra flag to track the direction
    // If direction is right to left we will revrese level list thats it
    public static List<List<BTNode>> zigZagLevelOrder(BTNode root) {
        // WRITE YOUR BRILLIANT CODE HERE
        List<List<BTNode>> myList = new ArrayList<>();
        Queue<BTNode> queue = new LinkedList<BTNode>();
        List<BTNode> levelList;
        queue.add(root);
        boolean isLeftToRight = true;
        while (!queue.isEmpty()) {
            levelList = new ArrayList<>();
           int size = queue.size();
           for (int i=0; i<size; i++) {
               BTNode node = queue.remove();
               levelList.add(node);
               if (node.left!=null) {
                  queue.add(node.left);
               }
               if (node.right!=null) {
                   queue.add(node.right);
               }
           }
           if (!isLeftToRight) {
               Collections.reverse(levelList);
           }
            isLeftToRight = !isLeftToRight;
            myList.add(levelList);
        }

        return myList;
    }
}
