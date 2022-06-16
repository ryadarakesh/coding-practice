package binary_search_trees;

import tress.BSTNode;
import tress.BinaryTreeUtils;

public class FloorValue {
    public static void main(String[] args) {
    BSTNode node = BinaryTreeUtils.createBST();
        System.out.println("Floor(7) -"+floor(node, 7).getData());
        System.out.println("Ceil(7) -"+ceil(node, 7).getData());
    }

    /* Ref - https://www.geeksforgeeks.org/floor-in-binary-search-tree-bst/
    1 Start at the root Node.
    2 If root->data == key,
     floor of the key is equal
     to the root.
    3 Else if root->data > key, then
     the floor of the key must lie in the
     left subtree.
    4 Else floor may lie in the right subtree
    but only if there is a value lesser than
    or equal to the key. If not, then the root is
    the key.
     */
    static BSTNode floor(BSTNode node, int ele) {
        if (node == null) {
            return null;
        }
        if (node.getData() == ele) {
            return node;
        }
        if (node.getData() > ele) {
            return floor(node.getLeft(), ele);
        }
        BSTNode floor = floor(node.getRight(), ele);
        return floor != null && floor.getData() <= ele ? floor : node;
    }

    static BSTNode ceil(BSTNode node, int ele) {
        if (node == null) {
            return null;
        }
        if (node.getData() == ele) {
            return node;
        }
        if (node.getData() < ele) {
            return ceil(node.getRight(), ele);
        }
        BSTNode ceil = ceil(node.getLeft(), ele);
        return ceil != null && ceil.getData() >= ele ? ceil : node;
    }
}
