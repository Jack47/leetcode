package DepthFirstSearch;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class MaxAreaOfIslandTest {
    @Test
    public void test() {
        MaxAreaOfIsland m = new MaxAreaOfIsland();
        int real = m.maxAreaOfIsland(new int[][]{{1, 0}, {1, 1}});
        assertEquals(3, real);

        real = m.maxAreaOfIsland(new int[][]{{1, 1, 0}, {1, 1, 0}, {1, 1, 1}});
        assertEquals(7, real);
    }
}
