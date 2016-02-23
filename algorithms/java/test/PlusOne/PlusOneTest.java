package PlusOne;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class PlusOneTest {
    @Test
    public void test() {
        PlusOne plusOne = new PlusOne();
        int digits[] = {1, 0};
        int [] expected = plusOne.plusOne(digits);
        assertArrayEquals(new int[] {1, 1}, expected);

        digits = new int[]{9, 9};
        expected = plusOne.plusOne(digits);
        assertArrayEquals(new int[] {1, 0, 0}, expected);

        digits = new int[]{0};
        expected = plusOne.plusOne(digits);
        assertArrayEquals(new int[] {1}, expected);
    }
}
