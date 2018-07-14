package StringRelated;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasicCalculatorTTest {
    @Test
    public void test() {
        BasicCalculatorIII bc = new BasicCalculatorIII();
        int result = bc.calculate("2-3-(1-2-3-(2-1))");
        assertEquals(4, result);

        result = bc.calculate("2147483647");
        assertEquals(2147483647, result);

        result = bc.calculate("1+(4+5+2)-3*(6+8)");
        assertEquals(-30, result);

        result = bc.calculate("2147483647");
        assertEquals(-30, result);
    }
}
