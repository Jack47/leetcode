package EliminationGame;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EliminationGameTest {
    @Test
    public void test() {
        EliminationGame sol = new EliminationGame();
        int result = sol.lastRemaining(1);
        assertEquals(1, result);

        result = sol.lastRemaining(2);
        assertEquals(2, result);

        result = sol.lastRemaining(3);
        assertEquals(2, result);

        result = sol.lastRemaining(4);
        assertEquals(2, result);

        result = sol.lastRemaining(5);
        assertEquals(2, result);


        result = sol.lastRemaining(100);
        assertEquals(54, result);

        result = sol.lastRemaining(101);
        assertEquals(54, result);

        result = sol.lastRemaining(102);
        assertEquals(56, result);
    }
}
