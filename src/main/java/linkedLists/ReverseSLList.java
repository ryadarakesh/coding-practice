package linkedLists;

import domain.SLNode;

public class ReverseSLList {
    public static void main(String[] args) {
        SLNode root = LinkedListUtils.createSinleLinkedListFromArray(new int[]{1, 2, 3, 4, 5, 6, 7});

        System.out.println("Before Reverse \n");
        LinkedListUtils.pintNodesData(root);

        SLNode reverse = reverseSLList(root);
        System.out.println("After Reverse \n");
        LinkedListUtils.pintNodesData(reverse);

        SLNode reverseRec = reverseRecursiveMain(reverse);
        System.out.println("After Reverse Back to Normal recursively\n");
        LinkedListUtils.pintNodesData(reverseRec);


    }

    // Every time make current node next to next of next node and then next node next to curr
    // And then make next as head
    static SLNode reverseSLList(SLNode node) {
        SLNode prev = null;
        SLNode current = node;
        SLNode next = null;
        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    static SLNode revHead;

    static SLNode reverseRecursiveMain(SLNode node) {
        revHead = null;
        reverseRecursive(node);
        return revHead;
    }

    // Recursively reach till end and make last node as head and return
    // while coming back assign next of next to node and make node next to null and return node till first node become last node
    static SLNode reverseRecursive(SLNode node) {
        if (node.getNext() == null) {
            revHead = node;
            return node;
        }
        SLNode next = reverseRecursive(node.getNext());
        node.setNext(null);
        next.setNext(node);
        return node;
    }
}
