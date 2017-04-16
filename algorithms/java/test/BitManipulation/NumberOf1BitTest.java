package BitManipulation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NumberOf1BitTest {
    @Test
    public void test() {
        NumberOf1Bits sol = new NumberOf1Bits();
        int result = sol.hammingWeight2(3);
        assertEquals(2, result);

        result = sol.hammingWeight2(4);
        assertEquals(1, result);
        result = sol.hammingWeight2(Integer.MAX_VALUE);
        assertEquals(31, result);
        result = sol.hammingWeight2(Integer.MIN_VALUE);
        assertEquals(1, result);
    }
}
