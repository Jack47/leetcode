package DivideAndConquer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReversepairsTest {
    @Test
    public void test() {
        ReversePairs s = new ReversePairs();
        int r = s.reversePairs(new int[]{1,3,2,3,1});
        assertEquals(2, r);
    }
}
