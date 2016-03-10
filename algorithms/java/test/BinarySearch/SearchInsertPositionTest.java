package BinarySearch;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SearchInsertPositionTest {
    @Test
    public void test() {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        int result = searchInsertPosition.searchInsert(new int[]{1,3,5,6}, 5);
        assertEquals(2, result);

        result = searchInsertPosition.searchInsert(new int[]{1,3,5,6}, 2);
        assertEquals(1, result);

        result = searchInsertPosition.searchInsert(new int[]{1,3,5,6}, 7);
        assertEquals(4, result);

        result = searchInsertPosition.searchInsert(new int[]{1,3,5,6}, 0);
        assertEquals(0, result);
    }
}
