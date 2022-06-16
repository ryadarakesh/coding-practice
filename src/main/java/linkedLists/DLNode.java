package linkedLists;

public class DLNode {
    public int data;
    public DLNode prev;
    public DLNode next;

    public DLNode(int data) {
        this.data = data;
    }

    public DLNode() {
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DLNode getPrev() {
        return prev;
    }

    public void setPrev(DLNode prev) {
        this.prev = prev;
    }

    public DLNode getNext() {
        return next;
    }

    public void setNext(DLNode next) {
        this.next = next;
    }
}
