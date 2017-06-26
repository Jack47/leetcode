package BinaryIndexedTree;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class BinaryIndexedTreeTest {
    @Test
    public void test() {
        ReversePairs sol = new ReversePairs();
        int ret = sol.reversePairs(new int[]{2, 4, 3, 5, 1});
        ret = sol.reversePairs(new int[]{-1, -1});
        assertEquals(0, ret);
    }
}
