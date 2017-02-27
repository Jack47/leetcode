package MinimumMoves;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinimumMovesToEqualArrayElementsTest {
    @Test
    public void test() {
        MinimumMovesToEqualArrayElements sol = new MinimumMovesToEqualArrayElements();
        int[] nums1 = {1, 7};
        assertEquals(6, sol.minMoves(nums1));

        int[] nums2 = {7};
        assertEquals(0, sol.minMoves(nums2));

        int[] nums3 = {5, 7, 9};
        assertEquals(6, sol.minMoves(nums3));

        int[] nums4 = {2, 5, 7, 9};
        assertEquals(15, sol.minMoves(nums4));
    }
}
