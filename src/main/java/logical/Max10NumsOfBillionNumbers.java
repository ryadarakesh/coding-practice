package logical;

import java.util.PriorityQueue;

/**
 * Given a big file containing billions of numbers, find the maximum 10 numbers
 * from that file.
 */
public class Max10NumsOfBillionNumbers {
    public static void main(String[] args) {
        maxNNumbersFromList(new int[] {1,4,2,3,5,8,7,6,9,10,14,15,18,19,20,51,100}, 5);
    }

    static void maxNNumbersFromList (int[] a, int n) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i=0; i<a.length;i++) {
            q.add(a[i]);
            // We are retaining N max elements at any time and removing min elements as it is Min Queue
            if (q.size() > n) {
                q.remove();
            }
        }

        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }
}
