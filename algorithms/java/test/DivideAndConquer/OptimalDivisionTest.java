package DivideAndConquer;

import static org.junit.Assert.assertEquals;

import DivideAndConquer.OptimalDivision;
import org.junit.Test;

public class OptimalDivisionTest {
    @Test
    public void test() {
        OptimalDivision op = new OptimalDivision();
        String ret = op.optimalDivision(new int[]{2});
        assertEquals("2", ret);
    }
}
