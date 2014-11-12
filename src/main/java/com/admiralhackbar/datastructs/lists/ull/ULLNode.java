package com.admiralhackbar.datastructs.lists.ull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.reflect.Array;

/**
 */
public class ULLNode<T> {
    private int size;
    private final Object[] arr;
    private ULLNode<T> next;

    public ULLNode(final int size,
            @Nonnull final T[] arr,
            @Nullable final ULLNode<T> next) {
        this.size = size;
        this.arr = arr;
        this.next = next;
    }

    public ULLNode(final int maxSize) {
        this.size = 0;
        this.arr = new Object[maxSize];
        this.next = null;
    }

    public int getSize() {
        return size;
    }

    @Nonnull
    public Object[] getArr() {
        return arr;
    }

    public T get(int index) {
        return (T) arr[index];
    }

    @Nullable
    public ULLNode<T> getNext() {
        return next;
    }

    public void setNext(ULLNode<T> next) {
        this.next = next;
    }

    public void insert(final int idx, @Nonnull final T value) {
        if (arr.length == size) {
            // TODO: Do some sort of "balancing" of values here
            final ULLNode newNext = new ULLNode(arr.length);
            newNext.insert(0, arr[arr.length -1]);
            newNext.setNext(this.next);
            this.next = newNext;
        }

        if (idx < size) {
            // inserting value at an allready occupied index, need to shift values by one.
            final int length = arr.length - (idx + 1);
            System.arraycopy(arr, idx, arr, idx + 1, length);
        }
        arr[idx] = value;
        size = Math.min(size +1, arr.length);
    }

    public int indexOf(final Object other) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(other)) {
                return i;
            }
        }
        return -1;
    }
}
