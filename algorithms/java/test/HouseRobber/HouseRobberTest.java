package HouseRobber;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HouseRobberTest {
    @Test
    public void test() {
        HouseRobber houseRobber = new HouseRobber();
        int result = houseRobber.rob(new int[]{});
        assertEquals(0, result);

        result = houseRobber.rob(new int[]{3, 4, 2, 1, 3, 2, 4});
        assertEquals(12, result);

        result = houseRobber.rob(new int[]{4, 4, 3, 1, 5, 6, 4});
        assertEquals(16, result);
    }

    @Test
    public void testII() {
        HouseRobberII houseRobber = new HouseRobberII();
        int result = houseRobber.rob(new int[]{});
        assertEquals(0, result);
        result = houseRobber.rob(new int[]{4});
        assertEquals(4, result);

        result = houseRobber.rob(new int[]{4, 4});
        assertEquals(4, result);

        result = houseRobber.rob(new int[]{4, 4, 3});
        assertEquals(4, result);

        result = houseRobber.rob(new int[]{4, 4, 3, 1});
        assertEquals(7, result);

        result = houseRobber.rob(new int[]{4, 4, 3, 1, 5});
        assertEquals(9, result);

        result = houseRobber.rob(new int[]{4, 4, 3, 1, 5, 6});
        assertEquals(12, result);

        result = houseRobber.rob(new int[]{4, 4, 3, 1, 5, 6, 4});
        assertEquals(13, result);
    }
}
