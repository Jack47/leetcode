package BitManipulation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinaryNumberWithAlternatingBitsTest {
    @Test
    public void test() {
        BinaryNumberWithAlternatingBits b = new BinaryNumberWithAlternatingBits();
        assertEquals(true, b.hasAlternatingBits(1));
        assertEquals(true, b.hasAlternatingBits(2));
        assertEquals(false, b.hasAlternatingBits(3));
        assertEquals(false, b.hasAlternatingBits(4));
        assertEquals(true, b.hasAlternatingBits(5));
        assertEquals(false, b.hasAlternatingBits(7));
        assertEquals(false, b.hasAlternatingBits(Integer.MAX_VALUE));
        assertEquals(false, b.hasAlternatingBits(Integer.MIN_VALUE));
        assertEquals(true, b.hasAlternatingBits(0xAAAAAAAA));
    }
}
