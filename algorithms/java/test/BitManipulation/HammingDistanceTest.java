package BitManipulation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HammingDistanceTest {
    @Test
    public void test() {
        HammingDistance hammingDistance = new HammingDistance();
        int result = hammingDistance.hammingDistance(2, 4);
        assertEquals(2, result);

        result = hammingDistance.hammingDistance(1, 3);
        assertEquals(1, result);

        result = hammingDistance.hammingDistance(9, 8);
        assertEquals(1, result);

    }
}
