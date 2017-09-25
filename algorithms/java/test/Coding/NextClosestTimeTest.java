package Coding;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NextClosestTimeTest {
    @Test
    public void test() {
        NextClosestTime s = new NextClosestTime();
        String r = s.nextClosestTime("23:59");
        assertEquals("22:22", r);
    }
}
