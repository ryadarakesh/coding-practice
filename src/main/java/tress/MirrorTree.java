package tress;

public class MirrorTree {
    public static void main(String[] args) {
       BTNode root = BinaryTreeUtils.createSimpleBinaryTree();
        System.out.println("Before Mirror");
        BinaryTreeUtils.printElementsInLevelOrder(root);
        mirror(root);
        System.out.println("\nAfter Mirror");
        BinaryTreeUtils.printElementsInLevelOrder(root);
        root = BinaryTreeUtils.createSimpleBinaryTree();
        System.out.println("\n Before Mirror");
        BinaryTreeUtils.printElementsInLevelOrder(root);
        mirrorFromLeaf(root);
        System.out.println("\n After Mirror");
        BinaryTreeUtils.printElementsInLevelOrder(root);

    }

    static void mirror (BTNode node) {
        if (node == null) {
            return;
        }
        BTNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        mirror(node.left);
        mirror(node.right);
    }

    static void mirrorFromLeaf (BTNode node) {
        if (node == null) {
            return;
        }
        mirror(node.left);
        mirror(node.right);
        BTNode temp = node.left;
        node.left = node.right;
        node.right = temp;

    }
}
