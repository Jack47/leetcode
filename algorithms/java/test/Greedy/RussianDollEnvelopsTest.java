package Greedy;

import static org.junit.Assert.assertEquals;

import DynamicProgramming.RussianDollEnvelopes;
import org.junit.Test;

public class RussianDollEnvelopsTest {
    @Test
    public void test() {
        RussianDollEnvelopes s = new RussianDollEnvelopes();
        int max = s.maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}});
        assertEquals(3, max);
    }
}
