package linkedLists;

import domain.SLNode;

public class RemoveNthNodeFromEnd {
    public static void main(String[] args) {
        SLNode slList = LinkedListUtils.createSinleLinkedListFromArray(new int[] {1,2,3,4,5,6,7,8,9,10});
        System.out.println("Before");
        LinkedListUtils.pintNodesData(slList);
        SLNode result = removeNthNodeFromEnd(slList, 4);
        System.out.println("\n After");
        LinkedListUtils.pintNodesData(result);



    }

    static SLNode removeNthNodeFromEnd (SLNode head, int n) {
        SLNode leader = head;
        SLNode follower = head;
        for (int i=0; i<n; i++) {
            leader = leader.getNext();
        }
        while (leader.getNext() != null) {
            follower = follower.getNext();
            leader = leader.getNext();
        }
        SLNode temp = follower.getNext();
        follower.setNext(temp.getNext());
        temp.setNext(null);
        return head;
    }



}
