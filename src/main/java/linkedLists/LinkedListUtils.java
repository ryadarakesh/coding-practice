package linkedLists;

import domain.SLNode;

public class LinkedListUtils {
    public static SLNode createSinleLinkedListFromArray(int[] a) {
        SLNode curr = new SLNode(a[0]);
        SLNode head = curr;
        for (int i = 1; i < a.length; i++) {
            SLNode node = new SLNode(a[i]);
            curr.setNext(node);
            curr = curr.getNext();
        }
        return head;
    }

    public static void pintNodesData(SLNode head) {
        SLNode curr = head;
        while (curr != null) {
            System.out.print(curr.getData() + " ");
            curr = curr.getNext();
        }
        System.out.println("\n");
    }
}
