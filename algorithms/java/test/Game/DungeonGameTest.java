package Game;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DungeonGameTest {
    @Test
    public void test() {
        DungeonGame dg = new DungeonGame();
        int result = dg.calculateMinimumHP(new int[][]{{-2, -3},{-5, -10}});
        assertEquals(16, result);

        result = dg.calculateMinimumHP(new int[][]{{-2, -3, 3},{-5, -10, 1},{10,30,-5}});
        assertEquals(7, result);
    }
}
