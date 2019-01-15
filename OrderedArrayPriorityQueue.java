package data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class OrderedArrayPriorityQueue<E extends Comparable<E>> implements PriorityQueue<E> {

    private E[] storage;
    private int maxSize, currentSize;

    public OrderedArrayPriorityQueue(int max) {

        maxSize = max;
        currentSize = 0;
        storage = (E[]) new Comparable[maxSize];
    }

    public OrderedArrayPriorityQueue() {

        this(DEFAULT_MAX_CAPACITY);
    }

    @Override
    public boolean insert(E object) {
        if (isFull())
            return false;
        int place = binarySearch(object, 0, currentSize - 1);
        for (int i = currentSize - 1; i >= place; i--)
            storage[i + 1] = storage[i];
        storage[place] = object;
        currentSize++;
        return true;

    }

    private int binarySearch(E object, int lo, int hi) {
        if (hi < lo)
            return lo;
        int mid = (hi + lo) / 2;
        if (object.compareTo(storage[mid]) >= 0)
            return binarySearch(object, lo, mid - 1);
        return binarySearch(object, mid + 1, hi);
    }

    @Override
    public E remove() {
        if (isEmpty())
            return null;
        return storage[--currentSize];
    }

    @Override
    public boolean delete(E obj) {
        if (isEmpty())
            return false;
        if (!contains(obj)) // check
            return false;
        int start = binarySearch(obj, 0, currentSize);
        int counter = 0;
        for (int i = start; i < currentSize; i++)
            if (storage[i].compareTo(obj) == 0)
                counter++;
        for (int i = start; i < currentSize - 1; i++) {
            storage[i] = storage[i + counter];
        }
        currentSize -= counter;
        return true;

    }

    @Override
    public E peek() {
        if (isEmpty())
            return null;
        return storage[currentSize - 1];
    }

    @Override
    public boolean contains(E obj) {

        return obj.compareTo(storage[binarySearch(obj, 0, currentSize - 1)]) == 0;

    }

    @Override
    public int size() {

        return currentSize;
    }

    @Override
    public void clear() {

        currentSize = 0;

    }

    @Override
    public boolean isEmpty() {

        return currentSize == 0;
    }

    @Override
    public boolean isFull() {

        return currentSize == maxSize;
    }

    @Override
    public Iterator<E> iterator() {
        return new IteratorHelper();
    }

    class IteratorHelper implements Iterator<E> {
        int iterIndex;
        long stateCheck;

        public IteratorHelper() {
            iterIndex = 0;
            stateCheck = currentSize;
        }

        public boolean hasNext() {
            if (stateCheck != currentSize)
                throw new NoSuchElementException();
            return iterIndex < currentSize;
        }

        public E next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return storage[iterIndex++];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}
