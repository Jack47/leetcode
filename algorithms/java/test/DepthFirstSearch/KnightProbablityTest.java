package DepthFirstSearch;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class KnightProbablityTest {
    @Test
    public void test() {
        KnightProbability k = new KnightProbability();
        double e = k.knightProbability(3, 2, 0, 0);
        assertEquals(0.0625, e, 0.001);

        e = k.knightProbability(100, 25, 0, 0);
        assertEquals(0.625, e, 0.001);
    }
}
