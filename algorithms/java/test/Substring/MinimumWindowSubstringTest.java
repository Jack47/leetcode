package Substring;

import static junit.framework.TestCase.assertEquals;

import TwoPointers.MinimumWindowSubstringT;
import org.junit.Test;

public class MinimumWindowSubstringTest {
    @Test
    public void test() {
        MinimumWindowSubstringT sol = new MinimumWindowSubstringT();
        String result = sol.minWindow("a", "a");
        assertEquals("a", result);

        result = sol.minWindow("AOBECEBANC", "ABC");
        assertEquals("CEBA", result);

        result = sol.minWindow("AADOBECODEBANC", "AABC");
        assertEquals("AADOBEC", result);
    }
}
