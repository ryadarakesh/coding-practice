package tress;

public class FindMaxInBinaryTree {
    public static void main(String[] args) {
        BTNode node = BinaryTreeUtils.createSimpleBinaryTree();
        System.out.println(" Level order traversal");
        BinaryTreeUtils.printElementsInLevelOrder(node);
        System.out.println("Max Element - " + getMaxEle(node));
        node.getLeft().getRight().getLeft().setData(30);
        node.getLeft().getLeft().getRight().setData(36);
        System.out.println(" Level order traversal");
        BinaryTreeUtils.printElementsInLevelOrder(node);
        System.out.println("Max Element - " + getMaxEle(node));
    }

    static int getMaxEle(BTNode node) {
        if (node == null) {
            return 0;
        }
        int max = node.data;
        int leftMax = getMaxEle(node.left);
        int rightMax = getMaxEle(node.right);
        max = max > leftMax ? max : leftMax;
        max = max > rightMax ? max : rightMax;
        return max;
    }
}
