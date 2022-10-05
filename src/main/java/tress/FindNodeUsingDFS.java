package tress;

public class FindNodeUsingDFS {

    public static void main(String[] args) {
        BTNode node = BinaryTreeUtils.createSimpleBinaryTree();
        System.out.println(" Foind node "+ findNodeUsingDFS(node, 15).data
        );
    }

    public static BTNode findNodeUsingDFS(BTNode root, int target) {
        if (root == null) {
            return null;
        }
        if (root.data == target) {
            return root;
        }
        // return non-null return value from the recursive calls
        BTNode left = findNodeUsingDFS(root.getLeft(), target);
        // If left side has the required value then only return otherwise continue traversing right
        if (left != null) {
            return left;
        }
        // at this point, we know left is null, and right could be null or non-null
        // we return right child's recursive call result directly because
        // - if it's non-null we should return it
        // - if it's null, then both left and right are null, we want to return null
        return findNodeUsingDFS(root.getRight(), target);

    }

}
