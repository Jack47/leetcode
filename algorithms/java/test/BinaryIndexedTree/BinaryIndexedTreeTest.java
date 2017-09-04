package BinaryIndexedTree;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class BinaryIndexedTreeTest {
    @Test
    public void test() {
        ReversePairs sol = new ReversePairs();
        int ret = sol.reversePairs(new int[]{2, 4, 3, 5, 1});
        ret = sol.reversePairs(new int[]{-1, -1});
        assertEquals(1, ret);
    }

    @Test
    public void test1() {
        ReversePairsT2 sol = new ReversePairsT2();
        int ret = sol.reversePairs(new int[]{3, 3, -3, -3, -3, 3});
        assertEquals(9, ret);
        ret = sol.reversePairs(new int[]{2147483647, 2147483647, -2147483647, -2147483647,
                -2147483647, 2147483647});
        assertEquals(9, ret);
    }
}
