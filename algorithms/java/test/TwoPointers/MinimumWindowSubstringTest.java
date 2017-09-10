package TwoPointers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinimumWindowSubstringTest {
    @Test
    public void test() {
        MinimumWindowSubstringTT s = new MinimumWindowSubstringTT();
        String r = s.minWindow("BANC", "BAC");
        assertEquals("BANC", r);
    }
}
