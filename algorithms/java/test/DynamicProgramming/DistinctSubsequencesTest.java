package DynamicProgramming;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DistinctSubsequencesTest {
    @Test
    public void test()
    {
        DistinctSubsequences s = new DistinctSubsequences();
        int result = s.numDistinct("rabbbit", "rabbit");
        assertEquals(3, result);
    }
}
