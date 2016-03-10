package Duplicate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ContainsDuplicateTest {
    @Test
    public void test() {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        int nums[] = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        boolean hasDuplicate = containsDuplicate.containsDuplicate(nums);
        assertEquals(false, hasDuplicate);

        hasDuplicate = containsDuplicate.containsDuplicate(new int[] {1,2,3,4,5,6,7,8,9,10,1});
        assertEquals(true, hasDuplicate);

        hasDuplicate = containsDuplicate.containsDuplicate(new int[] {1});
        assertEquals(false, hasDuplicate);
    }
}
