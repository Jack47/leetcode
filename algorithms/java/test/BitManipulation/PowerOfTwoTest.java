package BitManipulation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PowerOfTwoTest {
    @Test
    public void test(){
        PowerOfTwo sol = new PowerOfTwo();
        boolean ret = sol.isPowerOfTwo(2);
        assertEquals(true, ret);

        ret = sol.isPowerOfTwo(3);
        assertEquals(false, ret);

        ret = sol.isPowerOfTwo(-4);
        assertEquals(false, ret);
    }
}
