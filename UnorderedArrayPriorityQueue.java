package data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class UnorderedArrayPriorityQueue<E extends Comparable<E>> implements PriorityQueue<E> {

    private E[] storage;
    private int maxSize, currentSize;

    public UnorderedArrayPriorityQueue(int max) {
        maxSize = max;
        currentSize = 0;
        storage = (E[]) new Comparable[maxSize];
    }

    public UnorderedArrayPriorityQueue() {

        this(DEFAULT_MAX_CAPACITY);
    }

    @Override
    public boolean insert(E object) {
        if (isFull())
            return false;
        storage[currentSize++] = object;
        return true;
    }

    @Override
    public E remove() {

        if (isEmpty())
            return null;
        int counter = 0;
        E m = storage[0];
        for (int i = 1; i < currentSize; i++) {
            if (storage[i].compareTo(m) < 0) {
                m = storage[i];
                counter = i;
            }
        }
        for (int j = counter; j < currentSize - 1; j++) {
            storage[j] = storage[j + 1];
        }
        --currentSize;
        return m;
    }

    @Override
    public boolean delete(E obj) {
        boolean deleted = false;
        if (isEmpty())
            return false;
        // if(!contains(obj)) //check if these are necessary
        // return false;

        for (int i = 0; i < currentSize; i++) {
            if (storage[i].compareTo(obj) == 0) {
                for (int j = i; j < currentSize - 1; j++) {
                    storage[j] = storage[j + 1];
                }
                currentSize--;
                i--;
                deleted = true;
            }
        }

        return deleted;

    }

    @Override
    public E peek() {
        if (isEmpty())
            return null;
        E m = storage[0];
        for (int i = 0; i < currentSize; i++) {
            if (storage[i].compareTo(m) < 0)
                m = storage[i];
        }
        return m;
    }

    @Override
    public boolean contains(E obj) {
        for (int i = 0; i < currentSize; i++) {
            if (storage[i].compareTo(obj) == 0)
                return true;
        }
        return false;
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
