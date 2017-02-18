package IntersectionOfTwoArrays;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class IntersectionOfTwoArraysIITest {
    @Test
    public void test1(){
        IntersectionOfTwoArraysII solution = new IntersectionOfTwoArraysII();
        int nums1[] = new int[]{1, 2, 2, 1};
        int nums2[] = new int[]{2, 2};
        int ret[] = solution.intersect(nums1, nums2);
        assertArrayEquals(ret, new int[]{2, 2});

        nums1 = new int[]{3, 1, 2};
        nums2 = new int[]{1};
        ret = solution.intersect(nums1, nums2);
        assertArrayEquals(ret, new int[]{2, 2});

        nums1 = new int[]{5, 6, 7, 8, 9, 9, 10, 10, 12,};
        nums2 = new int[]{13, 5, 9, 10, 10, 12, 14};
        ret = solution.intersect(nums1, nums2);
        assertArrayEquals(ret, new int[]{5, 9, 10, 10, 12});
    }
}
