package tress;

/*
A node is said to be visible if its value is greater than all its parents
Input:
      5
     /  \
   3     10
  /  \   /
20   21 1

Output: 4
Explanation:
There are 4 visible nodes.
They are:
5: In the path 5 -> 3, 5 is the highest node value.
20: In the path 5 -> 3 -> 20, 20 is the highest node value.
21: In the path 5 -> 3 -> 21, 21 is the highest node value.
10: In the path 5 -> 10 -> 1, 10 is the highest node value.
 */
public class VisibleNodeCount {
    int count = 0;
    public static void main(String[] args) {
        BTNode root = BinaryTreeUtils.createNodeWithLeftAndRightNode(5, 3, 10);
        root.getLeft().setLeft(new BTNode(20));
        root.getLeft().setRight(new BTNode(21));
        root.getRight().setLeft(new BTNode(10));
        root.getRight().setLeft(new BTNode(1));
        VisibleNodeCount vc = new VisibleNodeCount();
        // Expected 4
        System.out.println(vc.visibleNodesCount(root));
    }

    int visibleNodesCount(BTNode node) {
        visibleNodesCount(node, Integer.MIN_VALUE);
        return count;
    }

    void visibleNodesCount (BTNode node, int max) {
        if (node==null) {
            return;
        }
        if (node.getData() > max) {
            count++;
            max = node.getData();
        }
        visibleNodesCount(node.getLeft(), max);
        visibleNodesCount(node.getRight(), max);
    }
}
