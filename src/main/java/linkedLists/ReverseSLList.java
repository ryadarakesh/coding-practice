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

    static SLNode reverseSLList(SLNode node) {
        SLNode head = node;
        while (node.getNext() != null) {
            SLNode next = node.getNext();
            node.setNext(next.getNext());
            next.setNext(head);
            head = next;
        }
        return head;
    }

    static SLNode revHead;

    static SLNode reverseRecursiveMain(SLNode node) {
        revHead = null;
        reverseRecursive(node);
        return revHead;
    }

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
