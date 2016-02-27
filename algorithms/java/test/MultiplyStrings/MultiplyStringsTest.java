package MultiplyStrings;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MultiplyStringsTest {
    @Test
    public void testAdd() {
        MultiplyStrings multiplyStrings = new MultiplyStrings();
        String sum = multiplyStrings.add("128", "0");
        assertEquals("128", sum);

        sum = multiplyStrings.add("128", "2");
        assertEquals("130", sum);

        sum = multiplyStrings.add("89283123", "89283123");
        assertEquals("178566246", sum);

        sum = multiplyStrings.add("8378361247892134", "89283123");
        assertEquals("8378361337175257", sum);
    }

    @Test
    public void testMultiplyDigit() {
        MultiplyStrings multiplyStrings = new MultiplyStrings();
        String product = multiplyStrings.multiply("128", 0);
        assertEquals("0", product);

        product = multiplyStrings.multiply("128", 8);
        assertEquals("1024", product);

        product = multiplyStrings.multiply("82837423", 9);
        assertEquals("745536807", product);
    }

    @Test
    public void testMultiply() {
        MultiplyStrings multiplyStrings = new MultiplyStrings();
        String product = multiplyStrings.multiply("128", "0");
        assertEquals("0", product);

        product = multiplyStrings.multiply("128", "128");
        assertEquals("16384", product);

        product = multiplyStrings.multiply("829387481314", "1");
        assertEquals("829387481314", product);

        product = multiplyStrings.multiply("829387481314", "2");
        assertEquals("1658774962628", product);
    }
}
