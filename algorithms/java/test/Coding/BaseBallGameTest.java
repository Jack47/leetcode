package Coding;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BaseBallGameTest {
    @Test
    public void test() {
        BaseBallGame s = new BaseBallGame();
        int p = s.calPoints(new String[]{"5","2","C","D","+"});
        assertEquals(30, p);
        p = s.calPoints(new String[]{"5","-2","4","C","D","9","+","+"});
        assertEquals(27, p);
    }
}
