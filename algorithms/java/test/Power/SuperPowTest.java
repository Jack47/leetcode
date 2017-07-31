package Power;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class SuperPowTest {
    @Test
    public void test() {
        SuperPow s = new SuperPow();
        int result = s.superPow(2, new int[]{3});
        assertEquals(8, result);
        result = s.superPow(2, new int[]{1, 0, 2, 4, 0});
        assertEquals(8, result);
    }
}
