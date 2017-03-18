package AZ;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BSTDistanceTest {
    @Test
    public void test() {
        BSTDistance s = new BSTDistance();
        int ret = s.bstDistance(new int[]{5, 6, 3, 1, 2, 4}, 6, 2, 4);
        assertEquals(3, ret);

        ret = s.bstDistance(new int[]{9, 7, 5, 3, 1}, 5, 7, 20);
        assertEquals(-1, ret);
    }
}
