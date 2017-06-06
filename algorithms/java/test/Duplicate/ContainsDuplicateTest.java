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

    @Test
    public void testII() {
        ContainsDuplicateII containsDuplicate = new ContainsDuplicateII();
        int nums[] = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        boolean hasDuplicate = containsDuplicate.containsNearbyDuplicate(nums, 10);
        assertEquals(false, hasDuplicate);

        hasDuplicate = containsDuplicate.containsNearbyDuplicate(new int[] {1,2,3,4,5,6,7,8,9,10,1}, 10);
        assertEquals(true, hasDuplicate);

        hasDuplicate = containsDuplicate.containsNearbyDuplicate(new int[] {1}, 1);
        assertEquals(false, hasDuplicate);

        hasDuplicate = containsDuplicate.containsNearbyDuplicate(new int[] {1, 2, 3, 1, 1}, 2);
        assertEquals(true, hasDuplicate);
    }
    @Test
    public void testIII() {
        ContainsDuplicateIII dup = new ContainsDuplicateIII();
        boolean has = dup.containsNearbyAlmostDuplicate(new int[]{-1,2147483647}, 1, 2147483647);
        assertEquals(false, has);
    }
}
