package Substring;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class MinimumWindowSubstringTest {
    @Test
    public void test() {
        MinimumWindowSubstring sol = new MinimumWindowSubstring();
        String result = sol.minWindow("a", "a");
        assertEquals("a", result);

        result = sol.minWindow("AOBECEBANC", "ABC");
        assertEquals("CEBA", result);

        result = sol.minWindow("AADOBECODEBANC", "AABC");
        assertEquals("AADOBEC", result);
    }
}
