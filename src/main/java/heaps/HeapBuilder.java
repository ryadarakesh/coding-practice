package heaps;

public class HeapBuilder {
    public static void main(String[] args) {
        BinaryHeap heap = new BinaryHeap(10, true);
        heap.insert(5);
        heap.insert(10);
        heap.insert(7);
        heap.insert(2);
        heap.insert(8);
        heap.insert(1);
        heap.insert(9);
        heap.insert(0);
        heap.insert(10);

        System.out.println("Priority Element without delete " + heap.getPriorityElement());
        System.out.println("Priority Element " + heap.deleteAndGetPriorityElement());
        System.out.println("Priority Element " + heap.deleteAndGetPriorityElement());
        System.out.println("Priority Element " + heap.deleteAndGetPriorityElement());
        System.out.println("Priority Element " + heap.deleteAndGetPriorityElement());
        System.out.println("Priority Element " + heap.deleteAndGetPriorityElement());
        System.out.println("Priority Element " + heap.deleteAndGetPriorityElement());
        System.out.println("Priority Element " + heap.deleteAndGetPriorityElement());
        System.out.println("Priority Element " + heap.deleteAndGetPriorityElement());
    }
}
