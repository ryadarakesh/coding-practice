package tress;

public class TreeDiameter {
    public static void main(String[] args) {
        BTNode node = BinaryTreeUtils.createNodeWithLeftAndRightNode(1, 2, 3);
        System.out.println(" Diameter - " + (diameter(node.left, 0) + diameter(node.right, 0) + 1));
        node.getLeft().setLeft(new BTNode(4));
        node.getLeft().setRight(new BTNode(6));
        node.getLeft().getLeft().setRight(new BTNode(5));
        node.getRight().setRight(new BTNode(10));
        System.out.println(" Diameter - " + (diameter(node.left, 0) + diameter(node.right, 0) + 1));
    }

    static int diameter(BTNode node, int diameter) {
        if (node == null) {
            return diameter;
        }
        return Math.max(diameter(node.left, diameter + 1), diameter(node.right, diameter + 1));
    }
}
