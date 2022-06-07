package tress;

public class IdenticalStructureTrees {
    public static void main(String[] args) {
        BTNode tree1 = BinaryTreeUtils.createSimpleBinaryTree();
        BTNode tree2 = BinaryTreeUtils.createSimpleBinaryTree();

        System.out.println(" Is Identically structured - " + isIdenticallyStructured(tree1, tree2));
        System.out.println(" Altering Tree 2 structure ");
        tree2.getLeft().getLeft().getLeft().setRight(new BTNode(56));
        System.out.println(" Is Identically structured - " + isIdenticallyStructured(tree1, tree2));
    }
    /*
        Both nodes should be either null or non null for each level and each child to be identical structured
     */
    static boolean isIdenticallyStructured(BTNode node1, BTNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return isIdenticallyStructured(node1.left, node2.left) && isIdenticallyStructured(node1.right, node2.right);
    }
}
