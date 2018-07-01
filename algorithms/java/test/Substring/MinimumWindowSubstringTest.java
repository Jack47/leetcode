package Substring;

import TwoPointers.MinimumWindowSubstringT;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
