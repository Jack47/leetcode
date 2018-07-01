package BitManipulation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
