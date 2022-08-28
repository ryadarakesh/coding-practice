package tress;

import java.util.ArrayList;
import java.util.List;

public class RightView {
    static int MAX_LEVEL;

    /*
        As it is right view we need to view root first and then right and left
        While visiting node if level is greater than max visited add to result
     */

    static void rightView(BTNode root, List<Integer> list, int level) {
        if (root == null) {
            return;
        }
        if (level > MAX_LEVEL) {
            MAX_LEVEL = level;
            System.out.println(" " + root.data);
            list.add(root.data);
        }
        rightView(root.right, list, level + 1);
        rightView(root.left, list, level + 1);
    }

    public static void main(String[] args) {
        BTNode tree = BinaryTreeUtils.createSimpleBinaryTree();
        List<Integer> list = rightSideView(tree);
    }

    public static List<Integer> rightSideView(BTNode root) {
        MAX_LEVEL = -1;
        List<Integer> list = new ArrayList();
        RightView.rightView(root, list, 0);
        return list;
    }
}
