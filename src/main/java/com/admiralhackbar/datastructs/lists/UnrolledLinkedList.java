package com.admiralhackbar.datastructs.lists;

import com.admiralhackbar.datastructs.lists.ull.ULLNode;

import javax.annotation.concurrent.NotThreadSafe;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 */
@NotThreadSafe
public class UnrolledLinkedList<T> implements List<T> {

    private int length;
    private ULLNode head;
    private final int maxSize;

    public UnrolledLinkedList(int maxSize) {
        this.maxSize = maxSize;
        this.head = new ULLNode(maxSize);
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        ULLNode<T> node = head;
        while (node.getNext() != null) {
            node = node.getNext();
        }
        // Last node is full, create a new one.
        // TODO: Balancing
        if (node.getSize() == maxSize) {
            final ULLNode<T> tempNode = new ULLNode<T>(maxSize);
            node.setNext(tempNode);
            node = tempNode;
        }
        node.insert(node.getSize(), t);
        length++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index " + index + " is not valid (length =" + length + ")");
        }
        ULLNode<T> node = head;
        while(node.getSize() <= index) {
            index -= node.getSize();
            node = node.getNext();
        }
        return node.get(index);
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {
        ULLNode<T> node = head;
        while(node.getSize() <= index) {
            index -= node.getSize();
            node = node.getNext();
        }
        node.insert(index, element);
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        ULLNode<T> node = head;
        while(node != null) {
            int nodeIndex = node.indexOf(o);
            if (nodeIndex > -1) {
                return index + nodeIndex;
            }
            index += node.getSize();
            node = node.getNext();
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
