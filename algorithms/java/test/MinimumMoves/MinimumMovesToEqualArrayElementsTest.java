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
    @Test
    public void testFindKth() {
        MinimumMovesII sol = new MinimumMovesII();
        int[] nums1 = {7, 1};
        assertEquals(1, sol.findKth(1, nums1, 0, 1));

        int[] nums2 = {7};
        assertEquals(7, sol.findKth(1, nums2, 0, 0));

        int[] nums3 = {9, 7, 5};
        assertEquals(7, sol.findKth(2, nums3, 0, 2));

        int[] nums4 = {7, 5, 2, 9};
        assertEquals(5, sol.findKth(2, nums4, 0, 3));

        int[] nums5 = {4, 7, 22, 30, 32};
        assertEquals(32, sol.findKth(5, nums5, 0, 4));
    }
    @Test
    public void testII() {
        MinimumMovesII sol = new MinimumMovesII();
        int[] nums1 = {1, 7};
        assertEquals(6, sol.minMoves2(nums1));

        int[] nums2 = {7};
        assertEquals(0, sol.minMoves2(nums2));

        int[] nums3 = {5, 7, 9};
        assertEquals(4, sol.minMoves2(nums3));

        int[] nums4 = {2, 5, 7, 9};
        assertEquals(9, sol.minMoves2(nums4));

        int[] nums5 = {4, 7, 22, 30, 32};
        assertEquals(51, sol.minMoves2(nums5));
    }
}
