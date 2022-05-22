package helpers;

import java.util.ArrayList;
import java.util.Arrays;

public class MyArrayList<T> {
    private Object[] elements;
    private int capacity;
    private int currentPos;

    public MyArrayList() {
        capacity = 5;
        elements = new Object[capacity];
        new ArrayList<>();
    }

    public void add(T ele) {
        add(ele, currentPos);
    }

    public void add(T element, int pos) {
        if (currentPos+1 == capacity) {
            ensureCapacity(pos+1);
        }
        elements[currentPos] = element;
        currentPos = pos+1;
    }

    public void ensureCapacity (int reqCapacity) {
        if (reqCapacity >= elements.length) {
            capacity = capacity * 2;
            elements = Arrays.copyOf(elements, capacity);
        }
    }

    public int size() {
        return currentPos;
    }

    public T get(int pos) {
        return (T) elements[pos];
    }
}
