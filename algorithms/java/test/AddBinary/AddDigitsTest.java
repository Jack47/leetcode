package AddBinary;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AddDigitsTest {
    @Test
    public void test() {
        AddDigits addDigits = new AddDigits();

        assertEquals(2, addDigits.addDigits(38));
        assertEquals(9, addDigits.addDigits(9));
        assertEquals(1, addDigits.addDigits(10));
        assertEquals(9, addDigits.addDigits(999));
        assertEquals(8, addDigits.addDigits(1579529852));
    }

}
