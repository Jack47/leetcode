package BinarySearch;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class SearchRangeTest {
    @Test
    public void test() {
        SearchRange searchRange = new SearchRange();
        int[] result = searchRange.searchRange(new int[] {}, 0);
        assertArrayEquals(new int[] {-1, -1}, result);

        result = searchRange.searchRange(new int[] {-2}, -2);
        assertArrayEquals(new int[] {0, 0}, result);

        result = searchRange.searchRange(new int[] {5, 7, 7, 8, 8, 10}, 7);
        assertArrayEquals(new int[] {1, 2}, result);

        result = searchRange.searchRange(new int[] {5, 7, 7, 8, 8, 8, 10}, 8);
        assertArrayEquals(new int[] {3, 5}, result);
    }
}
