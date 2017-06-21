package BinarySearch;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class SearchInRotatedSortedArrayTest {
    @Test
    public void test() {
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
        int result = s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 2);
        assertEquals(6, result);
    }
}
