package generic_trees;

public class GTNode {
    int data;
    GTNode firstChild;
    GTNode nextSibling;

    public GTNode() {
    }

    public GTNode(int data, GTNode firstChild, GTNode nextSibling) {
        this.data = data;
        this.firstChild = firstChild;
        this.nextSibling = nextSibling;
    }

    public GTNode(int data) {
        this.data = data;
    }



    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public GTNode getFirstChild() {
        return firstChild;
    }

    public void setFirstChild(GTNode firstChild) {
        this.firstChild = firstChild;
    }

    public GTNode getNextSibling() {
        return nextSibling;
    }

    public void setNextSibling(GTNode nextSibling) {
        this.nextSibling = nextSibling;
    }
}
