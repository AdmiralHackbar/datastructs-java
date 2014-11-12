package com.admiralhackbar.lists;

import com.admiralhackbar.datastructs.lists.UnrolledLinkedList;
import junit.framework.Assert;
import org.junit.Test;

/**
 */
public class TestUnrolledLinkedList {

    @Test
    public void test() {
        final UnrolledLinkedList<Integer> list = new UnrolledLinkedList(3);

        list.add(1);
        Assert.assertEquals(1, list.size());
        Assert.assertEquals(1, list.get(0).intValue());
    }

    @Test
    public void testIndexOfContains() {
        final UnrolledLinkedList<Integer> list = new UnrolledLinkedList(2);
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        Assert.assertEquals(1, list.indexOf(1));
        Assert.assertEquals(3, list.indexOf(3));
        Assert.assertTrue(list.contains(2));
        Assert.assertEquals(-1, list.indexOf(5));
    }
}
