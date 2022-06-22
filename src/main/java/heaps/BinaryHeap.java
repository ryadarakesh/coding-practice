package heaps;

public class BinaryHeap {
    int[] elements;
    int currentPos;
    int size;
    boolean isMinHeap;

    public BinaryHeap(int size, boolean isMinHeap) {
        elements = new int[size];
        this.size = size;
        this.isMinHeap = isMinHeap;
    }

    public void insert(int ele) {
        if (currentPos >= size) {
            return;
        }
        elements[currentPos++] = ele;
        heapifyMinHeapUp(currentPos - 1);
    }

    public int getParent(int elePos) {
        if (elePos < 0 || elePos >= currentPos) {
            return -1;
        }
        return (elePos - 1) / 2;
    }

    public int getLeftChild(int parentPos) {
        int left = 2 * parentPos + 1;
        if (left >= currentPos) {
            return -1;
        }
        return left;
    }

    public int getRightChild(int parentPos) {
        int right = 2 * parentPos + 2;
        if (right >= currentPos) {
            return -1;
        }
        return right;
    }

    public int getPriorityElement() {
        if (currentPos == 0) {
            return -1;
        }
        return elements[0];
    }

    public int deleteAndGetPriorityElement() {
        if (currentPos == 0) {
            return -1;
        }
        int priorityEle = elements[0];
        elements[0] = elements[currentPos - 1];
        currentPos--;
        heapifyMinHeapDown(0);
        return priorityEle;
    }

    public void heapifyMinHeapDown(int position) {
        int leftChild = getLeftChild(position);
        int rightChild = getRightChild(position);
        if (leftChild != -1 && (rightChild == -1 || elements[leftChild] < elements[rightChild]) && elements[leftChild] < elements[position]) {
            swapElements(leftChild, position);
            heapifyMinHeapDown(leftChild);
        } else if (rightChild != -1 && elements[rightChild] < elements[leftChild] && elements[rightChild] < elements[position]) {
            swapElements(rightChild, position);
            heapifyMinHeapDown(rightChild);
        }
    }

    public void heapifyMinHeapUp(int position) {
        int parentPos = getParent(position);
        if (parentPos != -1 && elements[parentPos] > elements[position]) {
            swapElements(parentPos, position);
            heapifyMinHeapUp(parentPos);
        }
    }

    private void swapElements(int pos1, int pos2) {
        int temp = elements[pos1];
        elements[pos1] = elements[pos2];
        elements[pos2] = temp;
    }

}
