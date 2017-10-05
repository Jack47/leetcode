package Game;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CanIWinTest {
    @Test
    public void test() {
        CanIWin c = new CanIWin();
        boolean real = c.canIWin(10, 11);
        assertEquals(false, real);
    }
}
