package Array;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RemoveDuplicatesTest {
    @Test
    public void test() {
        RemoveDuplicates sol = new RemoveDuplicates();
        int result = sol.removeDuplicates(new int[]{1, 1, 2, 3, 4, 5});
        assertEquals(5, result);

        result = sol.removeDuplicates(new int[]{1, 1, 2, 2, 3, 3});
        assertEquals(3, result);

        result = sol.removeDuplicates(new int[]{1, 2, 3, 4});
        assertEquals(4, result);
    }
}
