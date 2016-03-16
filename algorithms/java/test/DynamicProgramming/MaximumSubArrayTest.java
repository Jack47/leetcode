package DynamicProgramming;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaximumSubArrayTest {
    @Test
    public void test() {
        MaximumSubArray maximumSubArray = new MaximumSubArray();
        int result = maximumSubArray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        assertEquals(6, result);
    }
}
