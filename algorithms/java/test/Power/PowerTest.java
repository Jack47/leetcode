package Power;

import static junit.framework.TestCase.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class PowerTest {
    @Test
    public void testGetBitCount() {
        int result = Power.getBitCount(2);
        assertEquals(2, result);

        result = Power.getBitCount(4);
        assertEquals(3, result);

        result = Power.getBitCount(1 << 30);
        assertEquals(31, result);

    }

    @Test
    public void testToBinaryList() {
        List<Integer> lists = Power.toBinaryList(2);
        assertEquals(new LinkedList<Integer>() {{add(1);add(0);}}, lists);

        lists = Power.toBinaryList(3);
        assertEquals(new LinkedList<Integer>() {{add(1);add(1);}}, lists);

        lists = Power.toBinaryList(64);
        assertEquals(new LinkedList<Integer>() {{add(1);add(0);add(0);add(0);add(0);add(0);add(0);}}, lists);
    }

    @Test
    public void testPower() {
        Power pow = new Power();
        double result = pow.myPow(2, 0);
        assertEquals(1.0, result);

        pow = new Power();
        result = pow.myPow(1, 1);
        assertEquals(1.0, result);

        pow = new Power();
        result = pow.myPow(2.1, 2);
        assertEquals(4.41, result);

        pow = new Power();
        result = pow.myPow(2.1, 3);
        assertEquals(9.261000000000001, result);

        pow = new Power();
        result = pow.myPow(2.1, 4);
        assertEquals(19.4481, result);

        pow = new Power();
        result = pow.myPow(0.00001, 1);
        assertEquals(0.00001, result);

        pow = new Power();
        result = pow.myPow(0.00001, 2147483647);
        assertEquals(0.0, result);

        pow = new Power();
        result = pow.myPow(34.00515, 3);
        assertEquals(39321.86290543159, result);

        pow = new Power();
        result = pow.myPow(34.00515, -3);
        assertEquals(2.543114507074558E-5, result);

        pow = new Power();
        result = pow.myPow(1.00000, -2147483648);
        assertEquals(1.0, result);

        pow = new Power();
        result = pow.myPow(8.88023, 3);
        assertEquals(700.2814829452681, result);

        pow = new Power();
        result = pow.myPow(0.00001, 2);
        assertEquals(1.0000000000000002E-10, result);

        pow = new Power();
        //The result is different to math result due to double's precision
        result = pow.myPow(2.8796, 2);
        //assertEquals(29209616, result);
        assertEquals(8.29209616, result);
    }

}
