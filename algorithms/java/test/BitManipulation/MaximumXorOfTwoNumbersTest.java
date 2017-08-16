package BitManipulation;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class MaximumXorOfTwoNumbersTest {
    @Test
    public void test() {
        MaximumXorOfTwoNumbersInAnArray s = new MaximumXorOfTwoNumbersInAnArray();
        int result = s.findMaximumXOR(new int[]{2,3,5,8,10,25});
        assertEquals(28, result);
    }
}
