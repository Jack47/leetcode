package BitManipulation;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class SingleNumberIITest {
    @Test
    public void test() {
        SingleNumberII s = new SingleNumberII();
        int t = s.singleNumber(new int[]{-2,-2,1,1,-3,1,-3,-3,-4,-2});
        assertEquals(-4, t);
    }
}
