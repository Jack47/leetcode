package DynamicProgramming;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PaintHouseIITest {
    @Test
    public void test() {
        PaintHouseII p = new PaintHouseII();
        int result = p.minCostII(new int[][]{{1,2,3}, {4,5,6}, {2,1,2}});
        assertEquals(7, result);
    }
}
