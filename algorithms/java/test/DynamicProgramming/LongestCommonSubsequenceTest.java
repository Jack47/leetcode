package DynamicProgramming;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class LongestCommonSubsequenceTest {
    @Test
    public void test() {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        int result = lcs.longestCommonSubsequenceDP("bedaacbade", "dccaeedbeb");
        assertEquals(result, 5);
    }
}
