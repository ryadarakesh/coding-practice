package tress;

public class MaxlevelSum {
    public static void main(String[] args) {
        BTNode tree = BinaryTreeUtils.createSimpleBinaryTree();
        findmaxSumLevel(tree);
        tree.getLeft().getLeft().getLeft().setData(1);
        tree.getRight().getRight().getRight().setData(3);
        findmaxSumLevel(tree);
        tree.setData(100);
        findmaxSumLevel(tree);
        tree.getRight().setData(150);
        findmaxSumLevel(tree);
    }
    private static void findmaxSumLevel(BTNode tree) {
        int height = TreeHeight.height(tree);
        int maxSum = 0;
        int atLevel = -1;
        for (int i = 1; i <= height; i++) {
            int sum = findSumAtLevel(tree, i);
            if (sum > maxSum) {
                maxSum = sum;
                atLevel = i;
            }
        }
        System.out.println("Max Sum - "+maxSum+" found at level - "+atLevel);
    }

    static int findSumAtLevel(BTNode node, int level) {
        if (node == null) {
            return 0;
        } else if (level == 1) {
            return node.data;
        } else {
            return findSumAtLevel(node.left, level - 1) + findSumAtLevel(node.right, level - 1);
        }
    }
}
