package BitManipulation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReverseBitsTest {
    @Test
    public void test() {
        ReverseBitsT bits = new ReverseBitsT();
        int result = bits.reverseBits(1);
        assertEquals(-2147483648, result);

        result = bits.reverseBits(-2147483648);
        assertEquals(1, result);

        result = bits.reverseBits(43261596);
        assertEquals(964176192, result);

    }
}
