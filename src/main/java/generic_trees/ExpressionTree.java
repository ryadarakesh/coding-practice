package generic_trees;

import tress.EXPTNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ExpressionTree {
    public static void main(String[] args) {
        EXPTNode node = buildExpressionTree(new char[]{'A', 'B', 'C', '*', '+', 'D', '/'});
        printElementsInLevelOrder(node);
    }

    // Here operands need to be at leaves and operators are at non leaves
    static EXPTNode buildExpressionTree(char[] a) {
        Stack<EXPTNode> stack = new Stack<>();
        for (int i = 0; i < a.length; i++) {
            if (!isOperator(a[i])) {
                EXPTNode node = new EXPTNode(a[i]);
                stack.push(node);
            } else {
                EXPTNode node = new EXPTNode(a[i]);
                node.setRight(stack.pop());
                node.setLeft(stack.pop());
                stack.push(node);
            }
        }
        return stack.pop();
    }

    static boolean isOperator(char ch) {
        if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
            return true;
        }
        return false;
    }

    public static void printElementsInLevelOrder(EXPTNode node) {
        Queue<EXPTNode> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            EXPTNode curr = q.remove();
            System.out.print(curr.getData() + " ");
            if (curr.getLeft() != null) {
                q.add(curr.getLeft());
            }
            if (curr.getRight() != null) {
                q.add(curr.getRight());
            }
        }
    }

}
