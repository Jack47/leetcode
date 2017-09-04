package DivideAndConquer;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class CountOfRangeSumTest {
    @Test
    public void test() {
        CountOfRangeSum s = new CountOfRangeSum();
        int r = s.countRangeSum(new int[]{-2,-1}, -2, 2);
        assertEquals(2, r);
    }
}
