package BitManipulation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReverseIntegerTest {
    @Test
    public void test() {
        ReverseInteger ri = new ReverseInteger();
        int result = ri.reverse(123);
        assertEquals(321, result);

        result = ri.reverse(-321);
        assertEquals(-123, result);

        result = ri.reverse(2147483647);
        assertEquals(0, result);

        result = ri.reverse(-2147483647);
        assertEquals(0, result);

        result = ri.reverse(1534236469);
        assertEquals(0, result);

        result = ri.reverse(10);
        assertEquals(1, result);
    }
}
