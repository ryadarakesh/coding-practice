package heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ContinuousMedian {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    public static void main(String[] args) {
        ContinuousMedian cMedian = new ContinuousMedian();
        cMedian.add(10);
        cMedian.add(8);
        cMedian.add(15);
        cMedian.add(12);
        System.out.println("Median - " + cMedian.median());
        cMedian.add(7);
        System.out.println("Median - " + cMedian.median());
        cMedian.add(16);
        cMedian.add(20);
        cMedian.add(22);
        cMedian.add(5);
        cMedian.add(14);
        System.out.println("Median - " + cMedian.median());
    }

    public void add(int data) {
        // Insert in right queue initially irrespective of the size Heaps
        if (!maxHeap.isEmpty() && maxHeap.peek() > data) {
            maxHeap.add(data);
        } else {
            minHeap.add(data);
        }

        // Shuffle elements based on size of Heaps for balancing
        if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.add(minHeap.remove());
        } else if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.remove());
        }
    }

    public int median() {
        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else if (minHeap.size() < maxHeap.size()) {
            return maxHeap.peek();
        }
        return (minHeap.peek() + maxHeap.peek()) / 2;
    }
}
