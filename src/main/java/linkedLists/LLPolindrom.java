package linkedLists;

import domain.SLNode;

public class LLPolindrom {
    public static void main(String[] args) {
        SLNode ll = LinkedListUtils.createSinleLinkedListFromArray(new int[]{1, 2, 3, 4, 3, 2, 1});
        forward = ll;
        LinkedListUtils.pintNodesData(ll);
        System.out.println("Is Poilndrom " + isPolindrom(ll));

        ll = LinkedListUtils.createSinleLinkedListFromArray(new int[]{1, 2, 3, 4, 3, 2, 1,4});
        forward = ll;
        LinkedListUtils.pintNodesData(ll);
        System.out.println("Is Poilndrom " + isPolindrom(ll));
    }

    static SLNode forward = null;

    static boolean isPolindrom(SLNode node) {
        if (node == null) {
            return true;
        }
        boolean isPol = isPolindrom(node.getNext());
        isPol = isPol && forward.getData() == node.getData();
        forward = forward.getNext();
        return isPol;
    }
}
