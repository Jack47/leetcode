package DynamicProgramming;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TwoKeysBoardTest {
    @Test
    public void test() {
        TwoKeysBoard s = new TwoKeysBoard();
        int r = s.minSteps(6);
        assertEquals(5, r);
    }
}
