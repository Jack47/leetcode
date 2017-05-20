package BitManipulation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PowerOfFourTest {
    @Test
    public void test() {
        PowerOfFour f = new PowerOfFour();

        boolean ret = f.isPowerOfFour(2);
        assertEquals(false, ret);

        ret = f.isPowerOfFour(4);
        assertEquals(true, ret);

        ret = f.isPowerOfFour(Integer.MAX_VALUE);
        assertEquals(false, ret);

        ret = f.isPowerOfFour((int)Math.pow(2, 30));
        assertEquals(true, ret);

        ret = f.isPowerOfFour(Integer.MIN_VALUE);
        assertEquals(false, ret);

        ret = f.isPowerOfFour(8);
        assertEquals(false, ret);

        ret = f.isPowerOfFour(0);
        assertEquals(false, ret);
    }
}
