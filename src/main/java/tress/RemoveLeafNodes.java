package tress;

public class RemoveLeafNodes {
    public static void main(String[] args) {
        BTNode root = BinaryTreeUtils.createSimpleBinaryTree();
        BinaryTreeUtils.printElementsInLevelOrder(root);
        root = removeLeafNodes(root);
        System.out.println("");
        BinaryTreeUtils.printElementsInLevelOrder(root);

    }
    public static BTNode removeLeafNodes(BTNode node) {
        if (node == null) {
            return null;
        }
        if (node.left == null && node.right==null) {
            return null;
        }
        node.left = removeLeafNodes(node.left);
        node.right = removeLeafNodes(node.right);
        return node;
    }
}
