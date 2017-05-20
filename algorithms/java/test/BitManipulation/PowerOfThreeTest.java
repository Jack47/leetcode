package BitManipulation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PowerOfThreeTest {
    @Test
    public void test() {
        PowerOfThree sol = new PowerOfThree();
        boolean result = sol.isPowerOfThree(3);
        assertEquals(true, result);

        result = sol.isPowerOfThree(6);
        assertEquals(false, result);
    }
}
