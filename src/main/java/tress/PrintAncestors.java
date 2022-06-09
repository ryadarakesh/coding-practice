package tress;

import helpers.ArrayUtils;

public class PrintAncestors {
    public static void main(String[] args) {
        BTNode node = BinaryTreeUtils.createSimpleBinaryTree();

        printAncestors(node, 6);

        printAncestors(node, 13);

        printAncestors(node, 8);
    }

    static void printAncestors(BTNode node, int ancestorsOf) {
        printAncestors(node, ancestorsOf, new int[10], 0);
    }

    static void printAncestors(BTNode node, int ancestorsOf, int[] data, int pos) {
        if (node == null) {
            return;
        }
        data[pos] = node.data;
        if (ancestorsOf == node.data) {
            ArrayUtils.printElementsTill(data, pos);
            return;
        }
        printAncestors(node.left, ancestorsOf, data, pos + 1);
        printAncestors(node.right, ancestorsOf, data, pos + 1);
    }
}
