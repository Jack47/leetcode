package Greedy;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class RemoveKdigitsTest {
    @Test
    public void test() {
        RemoveKdigits r = new RemoveKdigits();
        String s = r.removeKdigitsEnhancement("1432219", 3);
        assertEquals("1219", s);
    }
}
