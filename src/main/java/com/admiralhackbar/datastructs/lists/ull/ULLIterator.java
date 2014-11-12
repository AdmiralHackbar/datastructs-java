package com.admiralhackbar.datastructs.lists.ull;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;
import java.util.Iterator;

/**
 */
@NotThreadSafe
public class ULLIterator<T> implements Iterator<T> {

    private ULLNode<T> currentNode;
    private int currentIndex = 0;
    private T next;

    public ULLIterator(@Nonnull final ULLNode<T> currentNode) {
        this.currentNode = currentNode;
        this.next = currentNode.get(0);
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public T next() {
        final T temp = next;
        incrementNext();
        return temp;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("'remove' is unsupported");
    }

    private void incrementNext() {
        if (currentIndex == currentNode.getSize() -1) { // next is last index in in current node
            while(currentNode != null && currentNode.getSize() > 0) {
                currentNode = currentNode.getNext();
            }

            if (currentNode == null) {
                next = null;
                return;
            } else {
                currentIndex = 0;
            }
        } else {
            currentIndex++;
        }
        next = currentNode.get(currentIndex);
    }

}
