package Sqrt;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SqrtTest {
    @Test
    public void testMySqrt() {
        Sqrt sqrt = new Sqrt();
        int result = sqrt.mySqrt(1);
        assertEquals(1, result);

        result = sqrt.mySqrt(3);
        assertEquals(1, result);

        result = sqrt.mySqrt(4);
        assertEquals(2, result);

        result = sqrt.mySqrt(128);
        assertEquals(11, result);

        result = sqrt.mySqrt(1024);
        assertEquals(32, result);

        result = sqrt.mySqrt(1025);
        assertEquals(32, result);

        result = sqrt.mySqrt(2147395599);
        assertEquals(46339, result);

        result = sqrt.mySqrt(Integer.MAX_VALUE);
        assertEquals(46340, result);

        result = sqrt.mySqrt(Integer.MIN_VALUE);
        assertEquals(46340, result);
    }
}
