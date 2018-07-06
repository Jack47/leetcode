package Geometry;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HilbertCurveTest {
    @Test
    public void test() {
        HilbertCurve hc = new HilbertCurve();

        /// iter: 0
        int real = hc.hilbert_curve(0,0,0);
        assertEquals(1, real);

        /// iter: 1
        real = hc.hilbert_curve(0,0,1);
        assertEquals(1, real);

        real = hc.hilbert_curve(0,1,1);
        assertEquals(2, real);

        real = hc.hilbert_curve(1,1,1);
        assertEquals(3, real);

        real = hc.hilbert_curve(1,0,1);
        assertEquals(4, real);

        /// iter: 2
        real = hc.hilbert_curve(1,1,2);
        assertEquals(3, real);

        real = hc.hilbert_curve(2,2,2);
        assertEquals(9, real);

        real = hc.hilbert_curve(1,3,2);
        assertEquals(7, real);

        real = hc.hilbert_curve(3,1,2);
        assertEquals(13, real);
    }

}
