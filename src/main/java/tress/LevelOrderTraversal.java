package tress;

import linkedLists.LinkedListUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        BTNode root = BinaryTreeUtils.createSimpleBinaryTree();
        /*List<Integer> result = levelOrderTraversal(root);
        result.stream().forEach(System.out::println);*/

        List<List<BTNode>> res = levelOrderTraversalEducative(root);
        System.out.println(res);

    }

    public static List<Integer> levelOrderTraversal(BTNode node) {
        Queue<BTNode> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        q.add(node);
        q.add(null);
        while (!q.isEmpty()) {
            BTNode curr = q.remove();
            result.add(curr.getData());
            if (curr.getLeft() != null) {
                q.add(curr.getLeft());
            }
            if (curr.getRight() != null) {
                q.add(curr.getRight());
            }
        }
        return result;
    }

    public static List<List<BTNode>> levelOrderTraversalEducative(BTNode root) {
        // WRITE YOUR BRILLIANT CODE HERE
        List<List<BTNode>> myList = new ArrayList<>();
        Queue<BTNode> queue = new LinkedList<BTNode>();
        List<BTNode> list = new ArrayList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            System.out.println("Inside");
            BTNode node = queue.remove();
            if (node==null) {
                myList.add(new ArrayList(list));
                list = new ArrayList<>();
                if (!queue.isEmpty()) {
                    queue.add(null);
                }

            } else {
                list.add(node);
                if (node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
        }

        return myList;
    }
}
