package data_structures;
/**
 * Anthony Reese
 * Program #3
 * cssc0931
 */
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinaryHeapPriorityQueue<E extends Comparable<E>> implements PriorityQueue<E> {
    private Wrapper<E>[] storage;
    private int maxSize, currentSize;
    private long entryNumber, modCounter;

    public BinaryHeapPriorityQueue(int max) {

        maxSize = max;
        currentSize = 0;
        storage = new Wrapper[max];
    }

    public BinaryHeapPriorityQueue() {

        this(DEFAULT_MAX_CAPACITY);
    }

    private int getNextChild(int current) {
        int left = (current << 1) + 1;
        int right = left + 1;
        if (right < currentSize) {
            if (storage[left].compareTo(storage[right]) < 0)
                return left;
            return right;
        }
        if (left < currentSize)
            return left;
        return -1;
    }

    protected class Wrapper<E> implements Comparable<Wrapper<E>> {
        long number;
        E data;

        public Wrapper(E d) {
            number = entryNumber++;
            data = d;
        }

        public int compareTo(Wrapper<E> o) {
            if (((Comparable<E>) data).compareTo(o.data) == 0)
                return (int) (number - o.number);
            return ((Comparable<E>) data).compareTo(o.data);
        }
    }

    private void trickleUp() {
        int newIndex = currentSize - 1;
        int parentIndex = (newIndex - 1) >> 1;
        Wrapper<E> newValue = storage[newIndex];
        while (parentIndex >= 0 && newValue.compareTo(storage[parentIndex]) < 0) {
            storage[newIndex] = storage[parentIndex];
            newIndex = parentIndex;
            parentIndex = (parentIndex - 1) >> 1;
        }
        storage[newIndex] = newValue;
    }

    private void trickleDown() {
        int current = 0;
        int child = getNextChild(current);
        while (child != -1 && storage[current].compareTo(storage[child]) < 0
                && storage[child].compareTo(storage[currentSize - 1]) < 0) {
            storage[current] = storage[child];
            current = child;
            child = getNextChild(current);
        }
        storage[current] = storage[currentSize - 1];
    }

    @Override
    public boolean insert(E object) {
        if (isFull())
            return false;
        storage[currentSize++] = new Wrapper<E>(object);
        trickleUp();
        modCounter++;
        return true;

    }

    @Override
    public E remove() {
        if (isEmpty())
            return null;
        E tmp = (E) storage[0].data;
        trickleDown();
        currentSize--;
        modCounter++;
        return tmp;
    }

    @Override
    public boolean delete(E obj) {
        if (isEmpty())
            return false;
        boolean flag = false;
        int holder[] = new int[currentSize];
        for (int i = 0; i < currentSize; i++) {
            if (obj.compareTo(storage[i].data) == 0) {
                flag = true;
                holder[i] = 1;
            } else {
                holder[i] = 0;
            }

        }
        clear();
        for (int i = 0; i < holder.length; i++) {
            if (holder[i] == 0)
                insert(storage[i].data);
        }
        modCounter++;
        return flag;
    }

    @Override
    public E peek() {
        if (isEmpty())
            return null;
        return storage[0].data;
    }

    @Override
    public boolean contains(E obj) {
        for (int i = 0; i < currentSize; i++) {
            if (obj.compareTo(storage[i].data) == 0)
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
            stateCheck = modCounter;
        }

        public boolean hasNext() {
            if (stateCheck != modCounter)
                throw new ConcurrentModificationException();
            return iterIndex < currentSize;
        }

        public E next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return storage[iterIndex++].data;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
