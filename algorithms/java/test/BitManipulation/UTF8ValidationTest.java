package BitManipulation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UTF8ValidationTest {
    @Test
    public void test() {
        UTF8Validation u = new UTF8Validation();
        boolean real = u.validUtf8(new int[]{240, 162, 138, 147});
        assertEquals(true, real);
    }
}
