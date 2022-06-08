package tress;

public class TreeHeight {

    public static void main(String[] args) {
        BTNode node = BinaryTreeUtils.createSimpleBinaryTree();
        System.out.println(" Level order traversal");
        BinaryTreeUtils.printElementsInLevelOrder(node);
        System.out.println("Height - " + height(node));
        node.getLeft().getRight().getLeft().setRight(BinaryTreeUtils.createNodeWithLeftAndRightNode(40, 41, 42));
        System.out.println(" Level order traversal");
        BinaryTreeUtils.printElementsInLevelOrder(node);
        System.out.println("Height " + height(node));
    }

    public static int height(BTNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }
}
