package Array;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class TrapRainWaterTest {
    @Test
    public void test() {
        TrapRainWaterT t = new TrapRainWaterT();
        int water = t.trap(new int[]{5,5,1,7,1,1,5,2,7,6});
        assertEquals(23, water);
    }
}
