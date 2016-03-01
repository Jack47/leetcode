package ClimbingStairs;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ClimbStairsTest {
    @Test
    public void test() {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        int result = climbingStairs.climbStairs(0);
        assertEquals(0, result);

        result = climbingStairs.climbStairs(1);
        assertEquals(1, result);

        result = climbingStairs.climbStairs(2);
        assertEquals(2, result);

        result = climbingStairs.climbStairs(3);
        assertEquals(3, result);

        result = climbingStairs.climbStairs(4);
        assertEquals(5, result);

        result = climbingStairs.climbStairs(5);
        assertEquals(8, result);
    }
}
