package Array;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RemoveElementTest {
    @Test
    public void test() {
        RemoveElement sol = new RemoveElement();
        int result = sol.removeElement(new int[]{4, 5, 6, 3, 7, 8}, 3);
        assertEquals(5, result);

        result = sol.removeElement(new int[]{5, 5, 6, 10, 7, 8}, 9);
        assertEquals(6, result);

        result = sol.removeElement(new int[]{}, 3);
        assertEquals(0, result);

        result = sol.removeElement(new int[]{3}, 3);
        assertEquals(0, result);
    }
}
