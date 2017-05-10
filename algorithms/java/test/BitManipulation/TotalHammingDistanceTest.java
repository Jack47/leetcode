package BitManipulation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TotalHammingDistanceTest {
    @Test
    public void test() {
        TotalHammingDistance sol = new TotalHammingDistance();
        int result = sol.totalHammingDistance(new int[]{4, 14, 2});
        assertEquals(6, result);
    }
}
