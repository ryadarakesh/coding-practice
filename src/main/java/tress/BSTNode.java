package tress;

public class BSTNode {
    int data;
    BSTNode left;
    BSTNode right;

    public BSTNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public BSTNode(int data, BSTNode left, BSTNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BSTNode getLeft() {
        return left;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }
}
