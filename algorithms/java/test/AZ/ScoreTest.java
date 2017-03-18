package AZ;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ScoreTest {
    @Test
    public void test() {
        Score score = new Score();
        String[] blocks1 = {"5", "-2", "4", "Z", "X", "9", "+", "+"};
        int cur = score.totalScore(blocks1, 8);
        assertEquals(27, cur);

        String[] blocks2 = {"1", "2", "+", "Z"};
        cur = score.totalScore(blocks2, 4);
        assertEquals(3, cur);
    }
}
