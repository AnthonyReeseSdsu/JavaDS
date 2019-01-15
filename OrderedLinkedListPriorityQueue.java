package data_structures;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class OrderedLinkedListPriorityQueue<E extends Comparable<E>> implements PriorityQueue<E> {

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

    public OrderedLinkedListPriorityQueue() {
        head = null;
    }

    @Override
    public boolean insert(E object) {

        Node<E> newNode = new Node<E>(object);
        Node<E> previous = null, current = head;
        while (current != null && ((Comparable<E>) object).compareTo(current.data) >= 0) {
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            newNode.next = head;
            head = newNode;
        } else {
            previous.next = newNode;
            newNode.next = current;
        }
        currentSize++;
        modCounter++;
        return true;
    }

    @Override
    public E remove() {
        if (isEmpty())
            return null;
        if (head == null)
            return null;
        E tmp = head.data;
        head = head.next;
        currentSize--;
        modCounter++;
        return tmp;
    }

    @Override
    public boolean delete(E obj) {
        boolean found = false;
        int counter = 0;
        Node<E> current = head, previous = null;
        while (current != null && current.data.compareTo(obj) != 0) {
            previous = current;
            current = current.next;
        }

        if (current == null)
            return false;
        found = true;
        if (previous == null) {
            while (current != null && current.data.compareTo(obj) == 0) {
                current = current.next;
                counter++;
            }
            head = current;
            currentSize -= counter;
        } else {
            while (current != null && current.data.compareTo(obj) == 0) {
                current = current.next;
                counter++;
            }
            previous.next = current;
            currentSize -= counter;
        }

        modCounter++;
        return found;
    }

    @Override
    public E peek() {
        if (head == null)
            return null;

        return head.data;
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
        head = null;
        currentSize = 0;
        modCounter++;

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

        public boolean hasNext() {
            if (modCheck != modCounter)
                throw new ConcurrentModificationException();
            return iterPtr != null;
        }

        public E next() {
            if (!hasNext())
                throw new NoSuchElementException();
            E tmp = iterPtr.data;
            iterPtr = iterPtr.next;
            return tmp;
        }
    }

}
