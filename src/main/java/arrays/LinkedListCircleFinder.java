package arrays;

public class LinkedListCircleFinder {

    public static void main(String[] args) {
        SinglyLinkedListNode head = new SinglyLinkedListNode(1, new SinglyLinkedListNode(2, new SinglyLinkedListNode(3, null)));
        head.getNext().getNext().setNext(head);
        System.out.println(hasCycle(head));

        head.getNext().getNext().setNext(null);
        System.out.println(hasCycle(head));
    }

    static boolean hasCycle(SinglyLinkedListNode head) {
        if (head == null) {
            return false;
        }
        SinglyLinkedListNode slow = head, fast = head;

        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

}
