package com.admiralhackbar.lists.ull;

import com.admiralhackbar.datastructs.lists.ull.ULLNode;
import junit.framework.Assert;
import org.junit.Test;

/**
 */
public class TestULLNode {

    @Test
    public void testInsert() {
        final ULLNode<Integer> node = new ULLNode<Integer>(3);

        // Test inserting
        node.insert(0, 1);
        Assert.assertEquals(1, node.get(0).intValue());
        Assert.assertEquals(1, node.getSize());

        // Test Inserting into empty position
        node.insert(1, 2);
        Assert.assertEquals(1, node.get(0).intValue());
        Assert.assertEquals(2, node.get(1).intValue());
        Assert.assertEquals(2, node.getSize());

        // Test inserting into occupied position
        node.insert(1, 3);
        Assert.assertEquals(1, node.get(0).intValue());
        Assert.assertEquals(3, node.get(1).intValue());
        Assert.assertEquals(2, node.get(2).intValue());
        Assert.assertEquals(3, node.getSize());

        // Test Inserting into "full" node
        node.insert(1, 4);
        Assert.assertEquals(1, node.get(0).intValue());
        Assert.assertEquals(4, node.get(1).intValue());
        Assert.assertEquals(3, node.get(2).intValue());
        Assert.assertEquals(3, node.getSize());
        Assert.assertNotNull(node.getNext());
        final ULLNode<Integer> next = node.getNext();
        Assert.assertEquals(2, next.get(0).intValue());
        Assert.assertEquals(1, next.getSize());
    }

    @Test
    public void testIndexOf() {
        final ULLNode<Integer> node = new ULLNode<Integer>(2);
        node.insert(0, 1);
        node.insert(1, 2);

        Assert.assertEquals(0, node.indexOf(1));
        Assert.assertEquals(1, node.indexOf(2));
        Assert.assertEquals(-1, node.indexOf(3));
    }
}
