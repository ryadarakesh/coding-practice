package linkedLists;

import domain.SLNode;

public class SingleLinkedList {
    public SLNode head;
    int len=0;
    SingleLinkedList() {
    }

    synchronized void addAtFirst(int data) {
        SLNode node = new SLNode(data);
        node.setNext(head);
        head = node;
        len++;
    }

    synchronized void deleteAtFirst() {
        SLNode temp = head;
        head = head.getNext();
        temp.setNext(null);
        len--;
    }

    synchronized void addAtEnd (int data) {
        SLNode node = new SLNode(data);
       SLNode curr=head;
       while (curr.getNext() != null) {
           curr = curr.getNext();
       }
       curr.setNext(node);
       len++;
    }

    synchronized void deleteAtEnd () {
        SLNode curr=head;
        while (curr.getNext() != null && curr.getNext().getNext()!=null) {
            curr = curr.getNext();
        }
        curr.setNext(null);
        len--;
    }

    synchronized void addAtPos(int data, int pos) {
        if (pos >= len) {
            new Exception("Invalid position");
        }
        SLNode node = new SLNode(data);
        if (head == null) {
            head = node;
        } else {
            SLNode curr = head;
            for (int i = 0; i < pos-1; i++) {
                curr = curr.getNext();
            }
            node.setNext(curr.getNext());
            curr.setNext(node);
        }
        len++;
    }

    synchronized void deleteAtPos(int pos) {
        if (pos >= len) {
            new Exception("Invalid position");
        }
        SLNode curr = head;
        for (int i = 0; i < pos-1; i++) {
            curr = curr.getNext();
        }
        SLNode temp = curr.getNext();
        curr.setNext(curr.getNext().getNext());
        temp.setNext(null);
    }

    void printData () {
        SLNode curr= head;
        while (curr != null) {
            System.out.print(curr.getData()+"  ");
            curr = curr.getNext();
        }
        System.out.println("");
    }


    public static void main (String[] args) {
        SingleLinkedList ll = new SingleLinkedList();
        ll.addAtFirst(1);
        ll.addAtEnd(2);
        ll.addAtEnd(4);
        ll.addAtEnd(5);
        ll.addAtPos(3, 2);
        ll.addAtEnd(6);
        ll.addAtFirst(0);
        ll.printData();
        ll.deleteAtFirst();
        ll.printData();
        ll.deleteAtEnd();
        ll.printData();
        ll.deleteAtPos(2);
        ll.printData();
    }


}
