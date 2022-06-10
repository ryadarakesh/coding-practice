package tress;

public class EXPTNode {
    char data;
    EXPTNode left;
    EXPTNode right;

    public EXPTNode(char data) {
        this.data = data;
    }

    public EXPTNode() {
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public EXPTNode getLeft() {
        return left;
    }

    public void setLeft(EXPTNode left) {
        this.left = left;
    }

    public EXPTNode getRight() {
        return right;
    }

    public void setRight(EXPTNode right) {
        this.right = right;
    }
}
