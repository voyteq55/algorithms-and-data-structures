package Lista07;

import java.util.Arrays;

public class Array3Heap<T extends Comparable<T>> implements Heap<T> {

    private static final int DEFAULT_CAPACITY = 16;
    private T[] _heapArray;
    private int _realSize;

    @SuppressWarnings("unchecked")
    public Array3Heap(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("heap array capacity has to be a positive integer");
        }
        _heapArray = (T[]) new Comparable[capacity];
        _realSize = 0;
    }

    public Array3Heap() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void clear() {
        for (int i = 0; i < _realSize; i++) {
            _heapArray[i] = null;
        }
        _realSize = 0;
    }

    @Override
    public void add(T element) {
        if (element == null) {
            throw new IllegalArgumentException("null cannot be passed as an element");
        }
        ensureCapacity();

        _realSize++;
        _heapArray[_realSize - 1] = element;
        swim(_realSize - 1);
    }

    public void addAll(Iterable<T> list) {
        for (T element : list) {
            add(element);
        }
    }

    @Override
    public T minimum() {
        if (_realSize == 0) {
            throw new IndexOutOfBoundsException("cannot access a minimum value from an empty heap");
        }
        T elementToReturn = _heapArray[0];
        _heapArray[0] = _heapArray[_realSize - 1];
        _heapArray[_realSize - 1] = null;
        _realSize--;
        sink();
        return elementToReturn;
    }

    @Override
    public boolean isEmpty() {
        return _realSize <= 0;
    }

    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (_realSize == _heapArray.length) {
            T[] newHeapArray = (T[]) new Comparable[_heapArray.length * 2];
            for (int i = 0; i < _heapArray.length; i++) {
                newHeapArray[i] = _heapArray[i];
            }
            _heapArray = newHeapArray;
        }
    }

    private void swim(int elementIndex) {
        while (elementIndex > 0) {
            int parentIndex = (elementIndex - 1) / 3;
            if (_heapArray[elementIndex].compareTo(_heapArray[parentIndex]) < 0) {
                swap(elementIndex, parentIndex);
                elementIndex = parentIndex;
            } else {
                break;
            }
        }
    }

    private void sink() {
        int elementIndex = 0;
        while (elementIndex < (_realSize + 1) / 3) {
            int minChildIndex = 3 * elementIndex + 1;
            int secondChildIndex = 3 * elementIndex + 2;
            if (secondChildIndex < _realSize && _heapArray[secondChildIndex].compareTo(_heapArray[minChildIndex]) < 0) {
                minChildIndex = secondChildIndex;
            }
            int thirdChildIndex = 3 * elementIndex + 3;
            if (thirdChildIndex < _realSize && _heapArray[thirdChildIndex].compareTo(_heapArray[minChildIndex]) < 0) {
                minChildIndex = thirdChildIndex;
            }
            if (_heapArray[minChildIndex].compareTo(_heapArray[elementIndex]) < 0) {
                swap(minChildIndex, elementIndex);
            } else {
                break;
            }
            elementIndex = minChildIndex;
        }
    }

    private void swap(int index1, int index2) {
        T temp = _heapArray[index1];
        _heapArray[index1] = _heapArray[index2];
        _heapArray[index2] = temp;
    }

    @Override
    public String toString() {
        return Arrays.toString(_heapArray);
    }
}
