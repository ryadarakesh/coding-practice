package tress;

public class BinaryTreeSize {
    public static void main(String[] args) {
        BTNode node = BinaryTreeUtils.createSimpleBinaryTree();
        System.out.println(" Level order traversal");
        BinaryTreeUtils.printElementsInLevelOrder(node);
        System.out.println("Max Element - " + size(node));

        System.out.println("Size of left sub tree "+ size(node.left));
        System.out.println("Size of right sub node "+ size(node.left));
    }

    static int size(BTNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.left) + size(node.right);
    }
}
