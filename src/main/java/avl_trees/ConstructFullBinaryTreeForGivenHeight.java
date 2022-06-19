package avl_trees;

public class ConstructFullBinaryTreeForGivenHeight {
    static int counter = 0;

    public static void main(String[] args) {
        AVLNode node = constructFullBinaryTreee(4);
        AVLTreeUtils.printInOrder(node);
    }

    public static AVLNode constructFullBinaryTreee (int h) {
        AVLNode node ;
        if (h == 0) {
            return null;
        }
        node = new AVLNode();
        node.setLeft(constructFullBinaryTreee(h-1));
        node.setData(counter++);
        node.setRight(constructFullBinaryTreee(h-1));
        return node;
    }
}
