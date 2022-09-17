package linkedLists;

import domain.SLNode;

/*
If L1 = 1-> 3 -> 5
and L2 = 2->4-> 6
result should be 1->2->3->4->5->6
 */
public class MergeSortedList {

    static SLNode mergeSorted(SLNode n1, SLNode n2) {
        if (n1 == null) {
            return n2;
        }
        if (n2 == null) {
            return n1;
        }
        if (n1.getData() < n2.getData()) {
            n1.setNext(mergeSorted(n1.getNext(), n2));
            return n1;
        } else {
            n2.setNext(mergeSorted(n1, n2.getNext()));
            return n2;
        }
    }

    public static void main(String[] args) {
        SLNode n1 = new SLNode(1, new SLNode(3, new SLNode(5)));
        SLNode n2 = new SLNode(2, new SLNode(4, new SLNode(6)));
        SLNode head = mergeSorted(n1, n2);
        LinkedListUtils.pintNodesData(head);
    }

}
