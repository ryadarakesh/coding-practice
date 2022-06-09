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

        BTNode node1 = BinaryTreeUtils.createSimpleBinaryTree();
        BTNode node2 = BinaryTreeUtils.createSimpleBinaryTree();
        mirrorFromLeaf(node2);
        System.out.println(" \n IS Mirror each other "+isMirrorEachOther(node1, node2));
        node2.getRight().setData(18);
        System.out.println(" \n IS Mirror each other "+isMirrorEachOther(node1, node2));

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

    static boolean isMirrorEachOther (BTNode node1, BTNode node2) {
        if (node1 == null && node2 == null) {
           return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.data != node2.data) {
            return false;
        }
        return isMirrorEachOther(node1.left, node2.right) && isMirrorEachOther(node1.right, node2.left);
    }
}
