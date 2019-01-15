package data_structures;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class UnorderedLinkedListPriorityQueue<E extends Comparable<E>> implements PriorityQueue<E> {

    private int currentSize;
    private long modCounter;

    private class Node<T> {
        T data;
        Node<T> next;

        public Node(T d) {
            data = d;
            next = null;
        }
    }

    private Node<E> head;

    public UnorderedLinkedListPriorityQueue() {
        head = null;
    }

    @Override
    public boolean insert(E object) {
        if (isFull())
            return false;
        Node<E> newNode = new Node<E>(object);

        newNode.next = head;
        head = newNode;
        currentSize++;
        modCounter++;
        return true;
    }

    @Override
    public E remove() {
        if (isEmpty())
            return null;
        Node<E> current = head, previous = null, replacement = null;
        E best = head.data;
        while (current != null) {
            if (best.compareTo(current.data) >= 0) {
                best = current.data;
                replacement = previous;
            }
            previous = current;
            current = current.next;
        }
        if (replacement == null)
            head = head.next;
        else {
            replacement.next = replacement.next.next;
        }
        currentSize--;
        modCounter++;
        return best;
    }

    @Override
    public boolean delete(E obj) {
        boolean found = false;
        Node<E> current = head, previous = null;
        while (current != null) {
            if (obj.compareTo(current.data) == 0) {
                currentSize--;
                found = true;
                if (current == head) {
                    head = head.next;
                } else {
                    previous.next = current.next;
                }
            }
            previous = current;
            current = current.next;

        }
        modCounter++;
        return found;
    }

    @Override
    public E peek() {
        if (isEmpty())
            return null;
        Node<E> current = head;
        E best = current.data;
        while (current != null) {
            if (best.compareTo(current.data) >= 0)
                best = current.data;
            current = current.next;
        }
        return best;
    }

    @Override
    public boolean contains(E obj) {
        if (isEmpty())
            return false;
        Node<E> current = head;
        while (current != null) {
            if (obj.compareTo(current.data) == 0)
                return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public void clear() {
        modCounter++;
        head = null;
        currentSize = 0;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new IteratorHelper();
    }

    class IteratorHelper implements Iterator<E> {
        private Node<E> iterPtr;

        long modCheck;

        public IteratorHelper() {
            iterPtr = head;
            modCheck = modCounter;
        }

        public boolean hasNext(){
            if( modCheck != modCounter) throw new ConcurrentModificationException();
            return iterPtr != null;
    }

        public E next(){
            if(!hasNext()) throw new NoSuchElementException();
                E tmp = iterPtr.data;
                iterPtr = iterPtr.next;
            return tmp;
        }
    }

}
