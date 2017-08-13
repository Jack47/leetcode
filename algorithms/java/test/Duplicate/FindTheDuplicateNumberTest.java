package Duplicate;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class FindTheDuplicateNumberTest {
    @Test
    public void test() {
        FindTheDuplicateNumber sol = new FindTheDuplicateNumber();
        int num = sol.findDuplicate(new int[]{1,2,3,2,4});
        assertEquals(num, 2);
    }
}
