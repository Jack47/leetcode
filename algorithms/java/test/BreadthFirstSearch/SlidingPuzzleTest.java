package BreadthFirstSearch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SlidingPuzzleTest {
    @Test
    public void test() {
        SlidingPuzzle sp = new SlidingPuzzle();
        int real = sp.slidingPuzzle(new int[][]{{1,2,3},{4,0,5}});
        assertEquals(real, 1);

        real = sp.slidingPuzzle(new int[][]{{1,2,3},{5,4,0}});
        assertEquals(real, -1);

        real = sp.slidingPuzzle(new int[][]{{3,2,4},{1,5,0}});
        assertEquals(real, 14);
    }
}
