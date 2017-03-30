package ContainerWithMostWater;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ContainerWithMostWaterTest {
    @Test
    public void test() {
        ContainerWithMostWater water = new ContainerWithMostWater();
        int[] heights = new int[]{1, 1};
        int max = water.maxArea(heights);
        assertEquals(1, max);

        heights = new int[]{1, 1, 2};
        max = water.maxArea(heights);
        assertEquals(2, max);

        heights = new int[]{1, 1, 2, 3};
        max = water.maxArea(heights);
        assertEquals(3, max);

        heights = new int[]{1, 1, 2, 3, 4};
        max = water.maxArea(heights);
        assertEquals(4, max);

        heights = new int[]{2, 3, 10, 5, 7, 8, 9};
        max = water.maxArea(heights);
        assertEquals(36, max);
    }
}
