package binary_search_trees;

import tress.BSTNode;
import tress.BinaryTreeUtils;

public class FloorValue {
    public static void main(String[] args) {
    BSTNode node = BinaryTreeUtils.createBST();
        System.out.println("Floor(7) -"+floor(node, 7).getData());
        System.out.println("Floor(7) -"+floorNonRecursive(node, 7).getData());
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

    static BSTNode floorNonRecursive(BSTNode node, int key) {
        BSTNode floorNode = null;
        while (node != null) {
            // If node data matches with key there is no better possible floor value, hence we can return
            if (node.getData() == key) {
                return node;
            }
            // if node data > key, it can never be floor so simply travel left
            else if (node.getData() > key) {
                node = node.getLeft();
            } else {
                // Here node data is less than key hence it can be a floor
                // so assign to floor aand search in right wheteher more proximate floor exists
                floorNode = node;
                node = node.getRight();
            }
        }
        return floorNode;
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

    static BSTNode ceilNonRecursive(BSTNode node, int key) {
        BSTNode celNode = null;
        while (node != null) {
            // If key matches node it is best cel which we can get, hence return
            if (node.getData() == key) {
                return node;
            } else if (node.getData()<key) {
                // It can never be cel hence just go towards right
                node = node.getRight();
            } else {
                // As here node.data is > than key, it can be the ceil but we can try to come proximate by going towards left
                celNode = node;
                node = node.getLeft();
            }
        }
        return celNode;
    }
}
