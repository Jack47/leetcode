package RangeSumQuery;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RangeSumQueryTest {
    @Test
    public void testImmutable() {
        RangeSumQueryImmutable rangeSumQuery = new RangeSumQueryImmutable(new int[]{-2, 0, 3, -5, 2, -1});
        int result = rangeSumQuery.sumRange(0, 0);
        assertEquals(-2, result);

        result = rangeSumQuery.sumRange(0, 3);
        assertEquals(-4, result);

        result = rangeSumQuery.sumRange(2, 5);
        assertEquals(-1, result);

        result = rangeSumQuery.sumRange(0, 5);
        assertEquals(-3, result);

        result = rangeSumQuery.sumRange(2, 3);
        assertEquals(-2, result);
    }

    @Test
    public void testMutable() {
        RangeSumQueryMutable rangeSumQuery = new RangeSumQueryMutable(new int[]{-2, 0, 3, -5, 2, -1});
        int result = rangeSumQuery.sumRange(0, 0);
        assertEquals(16, rangeSumQuery.tree.length);
        assertEquals(-3, rangeSumQuery.tree[1]);
        assertEquals(1, rangeSumQuery.tree[2]);
        assertEquals(-4, rangeSumQuery.tree[3]);
        assertEquals(-2, rangeSumQuery.tree[4]);
        assertEquals(3, rangeSumQuery.tree[5]);
        assertEquals(-3, rangeSumQuery.tree[6]);
        assertEquals(-1, rangeSumQuery.tree[7]);
        assertEquals(-2, rangeSumQuery.tree[8]);
        assertEquals(0, rangeSumQuery.tree[9]);
        assertEquals(-5, rangeSumQuery.tree[12]);
        assertEquals(2, rangeSumQuery.tree[13]);

        result = rangeSumQuery.sumRange(0, 0);
        assertEquals(-2, result);

        result = rangeSumQuery.sumRange(0, 3);
        assertEquals(-4, result);

        result = rangeSumQuery.sumRange(2, 5);
        assertEquals(-1, result);

        result = rangeSumQuery.sumRange(0, 5);
        assertEquals(-3, result);

        result = rangeSumQuery.sumRange(2, 3);
        assertEquals(-2, result);

        // test update
        rangeSumQuery.update(0, -1);
        result = rangeSumQuery.sumRange(0, 3);
        assertEquals(-3, result);

        result = rangeSumQuery.sumRange(2, 5);
        assertEquals(-1, result);

        rangeSumQuery.update(5, 0);
        result = rangeSumQuery.sumRange(0, 4);
        assertEquals(-1, result);
        result = rangeSumQuery.sumRange(0, 5);
        assertEquals(-1, result);

        result = rangeSumQuery.sumRange(2, 3);
        assertEquals(-2, result);

    }
    @Test
    public void testMutableLarge() {

    }
}
