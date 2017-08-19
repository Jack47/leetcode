package Graph;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class ArithmetricSliceTest {
    @Test
    public void test() {
        ArithmetricSlice s = new ArithmetricSlice();
        int result = s.numberOfArithmeticSlices(new int[]{7, 7, 7, 7});
        assertEquals(3, result);
    }
}
