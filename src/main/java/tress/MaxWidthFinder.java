package tress;

public class MaxWidthFinder {
    public static void main(String[] args) {
        BTNode tree = BinaryTreeUtils.createSimpleBinaryTree();
        System.out.println("Max Width - " + findMaxWidth(tree));
        tree.getLeft().getLeft().setLeft(null);
        System.out.println("Max Width - " + findMaxWidth(tree));
        tree.getLeft().getLeft().getRight().setLeft(new BTNode(19));
        System.out.println("Max Width - " + findMaxWidth(tree));
    }

    private static int findMaxWidth(BTNode tree) {
        int height = TreeHeight.height(tree);
        int maxWidth = 0;
        for (int i = 1; i <= height; i++) {
            int width = findWidthAtLevel(tree, i);
            if (width > maxWidth) {
                maxWidth = width;
            }
        }
        return maxWidth;
    }

    static int findWidthAtLevel(BTNode node, int level) {
        if (node == null) {
            return 0;
        } else if (level == 1) {
            return 1;
        } else {
            return findWidthAtLevel(node.left, level - 1) + findWidthAtLevel(node.right, level - 1);
        }
    }
}
