package DynamicProgramming;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class LongestCommonSubstringTest {
    @Test
    public void test() {
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        int result = lcs.longestCommonSubstring("ABCD", "CBCE");
        assertEquals(2, result);
    }
}
