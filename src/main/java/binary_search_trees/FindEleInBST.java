package binary_search_trees;

import tress.BSTNode;
import tress.BTNode;
import tress.BinaryTreeUtils;

public class FindEleInBST {
    public static void main(String[] args) {
        BSTNode node = BinaryTreeUtils.createBST();
        System.out.println("Element 5 found - "+findEle(node, 5));

        System.out.println("Element 10 found - "+findEle(node, 10));
    }

    static boolean findEle (BSTNode node, int ele) {
        if (node == null) {
            return false;
        }
        if (node.getData()==ele) {
            return true;
        }
        if (node.getData() > ele) {
            return findEle(node.getLeft(), ele);
        } else {
            return findEle(node.getRight(), ele);
        }
    }
}
