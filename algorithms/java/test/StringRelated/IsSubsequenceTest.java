package StringRelated;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IsSubsequenceTest {
    @Test
    public void test() {
        IsSubsequence sol = new IsSubsequence();
        boolean result = sol.isSubsequence("abc", "ahbgdc");
        assertEquals(true, result);

        result = sol.isSubsequence("axc", "ahbgdc");
        assertEquals(false, result);

        result = sol.isSubsequence("", "ahbgdc");
        assertEquals(true, result);

        result = sol.isSubsequence("axc", "");
        assertEquals(false, result);
    }
}
