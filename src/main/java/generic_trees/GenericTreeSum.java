package generic_trees;

public class GenericTreeSum {
    public static void main(String[] args) {
        GTNode tree = new GTNode(1);
        tree.setFirstChild(new GTNode(2));
        tree.getFirstChild().setNextSibling(new GTNode(3, new GTNode(6), new GTNode(4, new GTNode(5), null)));
        tree.getFirstChild().setFirstChild(new GTNode(7));
        System.out.println("Sum - "+sum(tree));
        tree.getFirstChild().getFirstChild().setNextSibling(new GTNode(8,null, new GTNode(9)));
        System.out.println("Sum - "+sum(tree));
    }

    public static int sum (GTNode node) {
        if (node == null) {
            return 0;
        }
        return node.data+ sum(node.firstChild)+sum(node.nextSibling);
    }
}
