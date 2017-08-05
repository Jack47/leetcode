package Combination;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CombinationSumIVTest {
    @Test
    public void test() {
        CombinationSumIV t = new CombinationSumIV();
        int e = t.combinationSum4(new int[]{1,2,3}, 32);
        assertEquals(181997601, e);
    }
}
