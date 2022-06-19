package tress;

public class RemoveHalfNodes {
    public static void main(String[] args) {
        BTNode root = BinaryTreeUtils.createSimpleBinaryTree();
        BinaryTreeUtils.printElementsInLevelOrder(root);
        root = removeHalfNodes(root);
        System.out.println("");
        BinaryTreeUtils.printElementsInLevelOrder(root);

    }
    public static BTNode removeHalfNodes(BTNode node) {
        if (node == null) {
            return null;
        }
        // Move till leaf nodes and remove from bottom otherwise process will stop in middle
        node.left = removeHalfNodes(node.left);
        node.right = removeHalfNodes(node.right);
        if (node.left == null && node.right== null) {
            return node;
        } else if (node.left == null){
            return node.right;
        } else if (node.right == null){
            return node.left;
        }
        return node;
    }
}
