package Array;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RemoveDuplicatesFromSortedArrayIITest {
    @Test
    public void test() {
        RemoveDuplicatesFromSortedArrayII sol = new RemoveDuplicatesFromSortedArrayII();

        int len = sol.removeDuplicates(new int[]{});
        assertEquals(0, len);

        len = sol.removeDuplicates(new int[]{1,2,2,2,3,4,5});
        assertEquals(6, len);

        len = sol.removeDuplicates(new int[]{1, 2, 2, 3, 4, 5});
        assertEquals(6, len);

        len = sol.removeDuplicates(new int[]{1, 1, 1, 1});
        assertEquals(2, len);

        len = sol.removeDuplicates(new int[]{1, 1});
        assertEquals(2, len);
    }
}
