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
            this.next = split();
            if (idx > size ) {
                this.next.insert(idx - size, value);
                return;
            }
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

    // visble for testing
    ULLNode<T> split() {
        final ULLNode newNext = new ULLNode(arr.length);
        System.arraycopy(arr, (arr.length + 1)/ 2, newNext.arr, 0, arr.length / 2);
        newNext.size = arr.length / 2;
        for (int i = (arr.length + 1) / 2; i < arr.length; i++) {
            arr[i] = null;
            --size;
        }
        newNext.next = this.next;
        this.next = newNext;
        return newNext;
    }
}
