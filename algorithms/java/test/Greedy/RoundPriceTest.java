package Greedy;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class RoundPriceTest {
    @Test
    public void test() {
        RoundPrice rp = new RoundPrice();
        int[] real = rp.round(new float[]{});
        assertArrayEquals(real, new int[0]);

        real = rp.round(new float[]{1.2F, 2.3F, 3.4F});
        assertArrayEquals(real, new int[]{1,2,4});

        real = rp.round(new float[]{1.7F, 1.8F, 1.9F});
        assertArrayEquals(real, new int[]{1,2,2});

        real = rp.round(new float[]{1.0F, 2.0F, 3.0F});
        assertArrayEquals(real, new int[]{1,2,3});

        real = rp.round(new float[]{1.1F, 2.1F, 3.1F});
        assertArrayEquals(real, new int[]{1,2,3});
    }
}
