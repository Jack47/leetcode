package StringRelated;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BasicCalculatorTest {
    @Test
    public void test() {
        BasicCalculator bc = new BasicCalculator();
        int result = bc.calculate("2-3-(1-2-3-(2-1))");
        assertEquals(4, result);

        result = bc.calculate("2147483647");
        assertEquals(2147483647, result);
    }
}
