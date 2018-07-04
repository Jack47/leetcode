package Stream;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MedianFinderTest {
    @Test
    public void test() {
        MedianFinder mf = new MedianFinder();
        mf.addNum(6);
        double real = mf.findMedian();
        assertEquals(6.0, real, 0.000001);

        mf.addNum(10);
        real = mf.findMedian();
        assertEquals(8.0, real, 0.00001);

        mf.addNum(2);
        real = mf.findMedian();
        assertEquals(6.0, real, 0.00001);
    }
    @Test
    public void test1() {
        MedianFinder mf = new MedianFinder();
        mf.addNum(40);
        double real = mf.findMedian();
        assertEquals(40, real, 0.00001);

        mf.addNum(12);
        real = mf.findMedian();
        assertEquals(26, real, 0.00001);

        mf.addNum(16);
        real = mf.findMedian();
        assertEquals(16, real, 0.00001);

        mf.addNum(14);
        real = mf.findMedian();
        assertEquals(15, real, 0.00001);

        mf.addNum(35);
        real = mf.findMedian();
        assertEquals(16, real, 0.00001);
    }
}
