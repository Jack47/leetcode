package StringRelated;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasicCalculatorIITTTest {
    @Test
    public void test() {
        BasicCalculatorIITT b = new BasicCalculatorIITT();
        int result = b.calculate("2+3/2");
        assertEquals(3, result);

        result = b.calculate(" 3/2 ");
        assertEquals(1, result);

        result = b.calculate("3+5 / 2");
        assertEquals(5, result);

        result = b.calculate("1-1 + 1");
        assertEquals(1, result);

        result = b.calculate("2147483647");
        assertEquals(2147483647, result);
    }
}
