package tress;

import java.util.Map;
import java.util.TreeMap;

public class VerticalSum {
    public static void main(String[] args) {
        BTNode node = BinaryTreeUtils.createSimpleBinaryTree();
        calculateVerticalSum(node);
        System.out.println("Test 2");
        BTNode nod1 = BinaryTreeUtils.createSmallBinaryTree();
        calculateVerticalSum(nod1);
    }

    static void calculateVerticalSum(BTNode node) {
        Map<Integer, Integer> sumMap = new TreeMap<>();
        verticalSum(node, sumMap, 0);
        sumMap.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " - " + entry.getValue() + " \n");
        });
    }

    static void verticalSum(BTNode node, Map<Integer, Integer> sumMap, int level) {
        if (node == null) {
            return;
        }
        sumMap.put(level, sumMap.getOrDefault(level, 0) + node.data);
        verticalSum(node.left, sumMap, level - 1);
        verticalSum(node.right, sumMap, level + 1);
    }

}
