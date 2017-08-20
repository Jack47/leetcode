package DynamicProgramming;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ArithmetricSliceIITest {
    @Test
    public void test() {
        ArithmetricSliceII s = new ArithmetricSliceII();
        int r = s.numberOfArithmeticSlices(new int[]{0, 2000000000, -294967296});
        assertEquals(0, r);
        r = s.numberOfArithmeticSlices(new int[]{2, 3, 4, 5, 6});
        assertEquals(7, r);
    }
}
