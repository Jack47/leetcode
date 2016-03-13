package BinarySearch;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class BoundSearchTest {
    @Test
    public void test() {
        BoundSearch boundSearch = new BoundSearch();
        int result = boundSearch.lower_bound(new int[] {-1, 0, 1, 3, 4, 5, 5, 7}, 5);
        assertEquals(5, result);

        result = boundSearch.lower_bound(new int[] {-1, 1, 1, 3, 4, 5, 5, 7}, 1);
        assertEquals(1, result);

        result = boundSearch.lower_bound(new int[] {-1, 1, 1, 3, 4, 5, 5, 7}, 0);
        assertEquals(-1, result);

        result = boundSearch.lower_bound(new int[] {-1, 1, 1, 3, 4, 5, 5, 7}, -2);
        assertEquals(-1, result);

        result = boundSearch.upper_bound(new int[] {-1, 0, 1, 3, 4, 5, 5, 7}, 5);
        assertEquals(6, result);

        result = boundSearch.upper_bound(new int[] {-1, 0, 1, 3, 4, 5, 5, 7}, -2);
        assertEquals(-1, result);

        result = boundSearch.upper_bound(new int[] {-1, 0, 1, 3, 4, 5, 5, 7, 7}, 7);
        assertEquals(8, result);
    }
}
