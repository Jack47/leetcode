package Array;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class MinimumSizeSubArraySumTest {
    @Test
    public void test() {
        MinimumSizeSubArraySumT s = new MinimumSizeSubArraySumT();
        int min = s.minSubArrayLen(7, new int[]{2,3,1,2,4,3});
        assertEquals(2, min);
    }
}
