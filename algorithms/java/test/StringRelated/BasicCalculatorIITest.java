package StringRelated;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BasicCalculatorIITest {
    @Test
    public void test() {
        BasicCalculatorII b = new BasicCalculatorII();
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
