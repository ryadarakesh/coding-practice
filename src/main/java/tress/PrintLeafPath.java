package tress;

import helpers.ArrayUtils;

public class PrintLeafPath {
    public static void main(String[] args) {
        BTNode tree = BinaryTreeUtils.createSimpleBinaryTree();
        printAllLeafsPath(tree, new int[10], 0);
    }

    public static void printAllLeafsPath(BTNode node, int[] path, int len) {
        if (node == null) {
            return;
        }
        path[len] = node.data;
        if (node.left == null && node.right == null) {
            ArrayUtils.printElementsTill(path, len);
        }
        printAllLeafsPath(node.left, path, len + 1);
        printAllLeafsPath(node.right, path, len + 1);
    }
}
