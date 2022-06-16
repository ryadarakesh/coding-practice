package avl_trees;

public class AVLNode {
    public int data;
    public AVLNode left;
    public AVLNode right;
    public int height;

    public AVLNode() {
    }

    public AVLNode(int data) {
        this.data = data;
    }

    public AVLNode(int data, AVLNode left, AVLNode right) {
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

    public AVLNode getLeft() {
        return left;
    }

    public void setLeft(AVLNode left) {
        this.left = left;
    }

    public AVLNode getRight() {
        return right;
    }

    public void setRight(AVLNode right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
