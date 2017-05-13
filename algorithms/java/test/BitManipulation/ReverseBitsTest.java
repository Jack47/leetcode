package BitManipulation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReverseBitsTest {
    @Test
    public void test() {
        ReverseBits bits = new ReverseBits();
        int result = bits.reverseBits(43261596);
        assertEquals(964176192, result);

        result = bits.reverseBits(-2147483648);
        assertEquals(1, result);

    }
}
