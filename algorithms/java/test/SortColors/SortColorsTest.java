package SortColors;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class SortColorsTest {
    @Test
    public void testBubbleSort() {
        SortColors sortColors = new SortColors();

        int[] nums = new int[]{2, 0, 2, 2, 0, 1, 2, 0, 0, 2};
        sortColors.sortColors(nums);
        assertArrayEquals(new int[]{0, 0, 0, 0, 1, 2, 2, 2, 2, 2}, nums);

        nums = new int[]{1, 0, 0, 2, 0, 1, 2, 0, 1, 0};
        sortColors.sortColors(nums);
        assertArrayEquals(new int[]{0, 0, 0, 0, 0, 1, 1, 1, 2, 2}, nums);
    }

    @Test
    public void testQuickSort() {
        SortColors sortColors = new SortColors();
        int[] nums = new int[]{2, 0, 2, 2, 0, 1, 2, 0, 0, 2};
        sortColors.quickSort(0, nums.length - 1, nums);
        assertArrayEquals(new int[]{0, 0, 0, 0, 1, 2, 2, 2, 2, 2}, nums);

        nums = new int[]{1, 0, 0, 2, 0, 1, 2, 0, 1, 0};
        sortColors.quickSort(0, nums.length - 1, nums);
        assertArrayEquals(new int[]{0, 0, 0, 0, 0, 1, 1, 1, 2, 2}, nums);
    }

    @Test
    public void testTwoPassSort() {
        SortColors sortColors = new SortColors();
        int[] nums = new int[]{2, 0, 2, 2, 0, 1, 2, 0, 0, 2};
        sortColors.sortColors2(nums);
        assertArrayEquals(new int[]{0, 0, 0, 0, 1, 2, 2, 2, 2, 2}, nums);

        nums = new int[]{1, 0, 0, 2, 0, 1, 2, 0, 1, 0};
        sortColors.sortColors2(nums);
        assertArrayEquals(new int[]{0, 0, 0, 0, 0, 1, 1, 1, 2, 2}, nums);

        nums = new int[]{1, 0};
        sortColors.sortColors2(nums);
        assertArrayEquals(new int[]{0, 1}, nums);

        nums = new int[]{1};
        sortColors.sortColors2(nums);
        assertArrayEquals(new int[]{1}, nums);
    }

    @Test
    public void testTwoPassSort3() {
        SortColors sortColors = new SortColors();
        int[] nums = new int[]{2, 0, 2, 2, 0, 1, 2, 0, 0, 2};
        sortColors.sortColors3(nums);
        assertArrayEquals(new int[]{0, 0, 0, 0, 1, 2, 2, 2, 2, 2}, nums);

        nums = new int[]{1, 0, 0, 2, 0, 1, 2, 0, 1, 0};
        sortColors.sortColors3(nums);
        assertArrayEquals(new int[]{0, 0, 0, 0, 0, 1, 1, 1, 2, 2}, nums);

        nums = new int[]{1, 0};
        sortColors.sortColors3(nums);
        assertArrayEquals(new int[]{0, 1}, nums);

        nums = new int[]{1};
        sortColors.sortColors3(nums);
        assertArrayEquals(new int[]{1}, nums);
    }
}
