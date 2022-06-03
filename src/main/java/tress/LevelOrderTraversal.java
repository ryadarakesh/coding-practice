package tress;

import linkedLists.LinkedListUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        BTNode root = BinaryTreeUtils.createSimpleBinaryTree();
        List<Integer> result = levelOrderTraversal(root);
        result.stream().forEach(System.out::println);
    }

    public static List<Integer> levelOrderTraversal(BTNode node) {
        Queue<BTNode> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        q.add(node);
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
}
