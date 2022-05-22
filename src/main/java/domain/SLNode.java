package domain;

public class SLNode {
    int data;
    SLNode next;

    public SLNode(int data, SLNode next) {
        this.data = data;
        this.next = next;
    }

    public SLNode(int data) {
        this.data = data;
    }

    public SLNode() {
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public SLNode getNext() {
        return next;
    }

    public void setNext(SLNode next) {
        this.next = next;
    }
}
