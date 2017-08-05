package Matrix;

import DivideAndConquer.LargestRectangeInHistogram;
import org.junit.Test;

public class LargestRectangeInHistogramTest {
    @Test
    public void test() {
        LargestRectangeInHistogram l = new LargestRectangeInHistogram();
        int r = l.largestRectangleArea(new int[]{2,1,5,6,2,3});
        r = l.largestRectangleArea(new int[]{1,2,3,4,5});
    }
}
