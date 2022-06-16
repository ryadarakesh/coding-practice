package binary_search_trees;

import linkedLists.DLNode;
import tress.BSTNode;

public class LinkedListToBST {
    public static void main(String[] args) {
        DLNode node = new DLNode(1);
        node.setNext(new DLNode(2));
        node.getNext().setNext(new DLNode(3));
        node.next.next.setNext(new DLNode(4));
        node.next.next.next.setNext(new DLNode(5));
        BSTNode tree = llToBST(node);
        BSTUtis.printInOrder(tree);
    }

    /*
    Similar to array to BST here also we will find nid and make it as root.
    Root left would be from constructed from head to mid previous and right is caliculated from mid next to end
    Here while caliculating mid , once mid is found we are making mid previus pointing to null instead of mid to identify where to stop the left
     */
    static BSTNode llToBST(DLNode head) {
        if (head == null) {
            return null;
        }
        DLNode mid = getMid(head);
        BSTNode root = new BSTNode(mid.getData());
        if (head == mid) {
            return root;
        }
        root.setLeft(llToBST(head));// This will stop before mid as we disconnected the mid from previous
        root.setRight(llToBST(mid.getNext()));// This will start from mid next and end where the disconnect or at tail
        return root;
    }

    static DLNode getMid(DLNode head) {
        DLNode slow = head;
        DLNode fast = head;
        DLNode prev = head;
        while (fast != null && fast.getNext() != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // Disconnect mid (slow) from previous, this is the heart of finding where to stop left tree
        if (prev != null) {
            prev.next = null;
        }
        return slow;
    }
}
