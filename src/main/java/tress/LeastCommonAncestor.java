package tress;

public class LeastCommonAncestor {
    public static void main(String[] args) {
        BTNode node = BinaryTreeUtils.createSimpleBinaryTree();
        System.out.println(lca(node, 12, 15).data);
        System.out.println(lca(node, 10, 11).data);
    }

    static BTNode lca(BTNode node, int d1, int d2) {
        if (node == null) {
            return null;
        }
        // If any item is matching the node is in path
        if (node.data == d1 || node.data == d2) {
            return node;
        }
        BTNode left = lca(node.left, d1, d2);
        BTNode right = lca(node.right, d1, d2);
        // If any node has both left and right not null that is lca
        if (left != null && right != null) {
            return node;
        }
        return left != null ? left : right;
    }
}
