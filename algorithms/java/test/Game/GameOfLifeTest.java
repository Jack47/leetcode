package Game;

import static Game.GameOfLife.*;
import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class GameOfLifeTest {
    @Test
    public void testGetLiveNeighbor() {
        GameOfLife gameOfLife = new GameOfLife();
        /**
         * Test one row
         */
        int result = gameOfLife.getLiveNeighBor(new int[][]{{1, 0, 1}}, 0, 0);
        assertEquals(0, result);
        result = gameOfLife.getLiveNeighBor(new int[][]{{1, 0, 1}}, 0, 1);
        assertEquals(2, result);
        result = gameOfLife.getLiveNeighBor(new int[][]{{1, 0, 1}}, 0, 2);
        assertEquals(0, result);

        /**
         * Test tow rows
         */
        result = gameOfLife.getLiveNeighBor(new int[][]{{1, 0, 1}, {1, 1, 0}}, 0, 0);
        assertEquals(2, result);
        result = gameOfLife.getLiveNeighBor(new int[][]{{1, 0, 1}, {1, 1, 0}}, 0, 1);
        assertEquals(4, result);
        result = gameOfLife.getLiveNeighBor(new int[][]{{1, 0, 1}, {1, 1, 0}}, 0, 2);
        assertEquals(1, result);
        result = gameOfLife.getLiveNeighBor(new int[][]{{1, 0, 1}, {1, 1, 0}}, 1, 0);
        assertEquals(2, result);
        result = gameOfLife.getLiveNeighBor(new int[][]{{1, 0, 1}, {1, 1, 0}}, 1, 1);
        assertEquals(3, result);
        result = gameOfLife.getLiveNeighBor(new int[][]{{1, 0, 1}, {1, 1, 0}}, 1, 2);
        assertEquals(2, result);

        /**
         * Test three rows
         */
        result = gameOfLife.getLiveNeighBor(new int[][]{{1, 0, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 0);
        assertEquals(3, result);
        result = gameOfLife.getLiveNeighBor(new int[][]{{1, 0, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1);
        assertEquals(5, result);
        result = gameOfLife.getLiveNeighBor(new int[][]{{1, 0, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 2);
        assertEquals(3, result);
        result = gameOfLife.getLiveNeighBor(new int[][]{{1, 0, 1}, {1, 1, 0}, {1, 0, 1}}, 2, 0);
        assertEquals(2, result);
        result = gameOfLife.getLiveNeighBor(new int[][]{{1, 0, 1}, {1, 1, 0}, {1, 0, 1}}, 2, 1);
        assertEquals(4, result);
        result = gameOfLife.getLiveNeighBor(new int[][]{{1, 0, 1}, {1, 1, 0}, {1, 0, 1}}, 2, 2);
        assertEquals(1, result);
    }

    @Test
    public void testGetNextStatus() {
        GameOfLife gameOfLife = new GameOfLife();
        Status status = gameOfLife.getNextStatus(Status.Live, 0);
        assertEquals(Status.Dead, status);
        status = gameOfLife.getNextStatus(Status.Live, 1);
        assertEquals(Status.Dead, status);

        status = gameOfLife.getNextStatus(Status.Live, 2);
        assertEquals(Status.Live, status);
        status = gameOfLife.getNextStatus(Status.Live, 3);
        assertEquals(Status.Live, status);

        status = gameOfLife.getNextStatus(Status.Live, 4);
        assertEquals(Status.Dead, status);
        status = gameOfLife.getNextStatus(Status.Live, 5);
        assertEquals(Status.Dead, status);
        status = gameOfLife.getNextStatus(Status.Live, 6);
        assertEquals(Status.Dead, status);
        status = gameOfLife.getNextStatus(Status.Live, 7);
        assertEquals(Status.Dead, status);
        status = gameOfLife.getNextStatus(Status.Live, 8);
        assertEquals(Status.Dead, status);

        status = gameOfLife.getNextStatus(Status.Dead, 3);
        assertEquals(Status.Live, status);

        status = gameOfLife.getNextStatus(Status.Dead, 2);
        assertEquals(Status.Dead, status);
        status = gameOfLife.getNextStatus(Status.Dead, 4);
        assertEquals(Status.Dead, status);
    }
}
