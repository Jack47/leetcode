package SegmentTree;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SegmentTreeTest {
    @Test
    public void test() {
        CountOfRangeSums c = new CountOfRangeSums();
        int count = c.countRangeSum(new int[]{-2,5,-1}, -2, 2);
        assertEquals(3, count);
    }
    @Test
    public void test1() {
        SegmentTree segmentTree = new SegmentTree(new int[]{});
        segmentTree = new SegmentTree(new int[]{-1});
        int result = segmentTree.query(0, 0);
        assertEquals(-1, result);
        segmentTree = new SegmentTree(new int[]{-2, 0, 3, -5, 2, -1});
        assertEquals(4 , segmentTree.trees[1]);
        assertEquals(1 , segmentTree.trees[2]);
        assertEquals(4 , segmentTree.trees[3]);
        assertEquals(1 , segmentTree.trees[4]);
        assertEquals(3 , segmentTree.trees[5]);
        assertEquals(4 , segmentTree.trees[6]);
        assertEquals(6 , segmentTree.trees[7]);
        assertEquals(1 , segmentTree.trees[8]);
        assertEquals(2 , segmentTree.trees[9]);
        assertEquals(4 , segmentTree.trees[12]);
        assertEquals(5 , segmentTree.trees[13]);



        result = segmentTree.query(0, 0);
        assertEquals(-2, result);

        result = segmentTree.query(0, 2);
        assertEquals(-2, result);

        result = segmentTree.query(1, 2);
        assertEquals(0, result);

        result = segmentTree.query(0, 3);
        assertEquals(-5, result);

        result = segmentTree.query(2, 5);
        assertEquals(-5, result);

        result = segmentTree.query(0, 5);
        assertEquals(-5, result);

        result = segmentTree.query(4, 5);
        assertEquals(-1, result);

        result = segmentTree.query(2, 3);
        assertEquals(-5, result);
    }

    @Test
    public void test2() {
        SegmentTree segmentTree = new SegmentTree(new int[]{-2, 0, 3, -5, 2, -1});

        assertEquals(4 , segmentTree.trees[1]);
        assertEquals(1 , segmentTree.trees[2]);
        assertEquals(4 , segmentTree.trees[3]);
        assertEquals(1 , segmentTree.trees[4]);
        assertEquals(3 , segmentTree.trees[5]);
        assertEquals(4 , segmentTree.trees[6]);
        assertEquals(6 , segmentTree.trees[7]);
        assertEquals(1 , segmentTree.trees[8]);
        assertEquals(2 , segmentTree.trees[9]);
        assertEquals(4 , segmentTree.trees[12]);
        assertEquals(5 , segmentTree.trees[13]);




        int result = segmentTree.query(0, 2);
        assertEquals(-2, result);

        result = segmentTree.query(0, 2);
        assertEquals(-2, result);

        result = segmentTree.query(1, 2);
        assertEquals(0, result);

        result = segmentTree.query(0, 3);
        assertEquals(-5, result);

        result = segmentTree.query(2, 5);
    }
}
