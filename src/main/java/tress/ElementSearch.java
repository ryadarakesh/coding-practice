package tress;

public class ElementSearch {
    public static void main(String[] args) {
        BTNode node = BinaryTreeUtils.createSimpleBinaryTree();
        System.out.println(" Level order traversal");
        BinaryTreeUtils.printElementsInLevelOrder(node);
        System.out.println("\n");
        System.out.println("Found Ele 15 in Tree - " + serachElementInTree(node, 15));
        System.out.println("Found Ele 32 in Tree - " + serachElementInTree(node, 32));

    }

    static boolean serachElementInTree(BTNode node, int ele) {
        if (node == null) {
            return false;
        }
        if (node.data == ele) {
            return true;
        }
        return serachElementInTree(node.left, ele) || serachElementInTree(node.right, ele);
    }
}
