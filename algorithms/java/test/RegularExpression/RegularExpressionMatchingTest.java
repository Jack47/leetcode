package RegularExpression;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RegularExpressionMatchingTest {
    @Test
    public void test() {
        RegularExpressionMatching r = new RegularExpressionMatching();
        boolean result = r.isMatch("abcd", "abcd");
        assertEquals(true, result);

        result = r.isMatch("abc", "abcd");
        assertEquals(false, result);

        result = r.isMatch("abcd", "abc");
        assertEquals(false, result);

        result = r.isMatch("abcd", "abc.");
        assertEquals(true, result);

        result = r.isMatch("abdc", "ab.c");
        assertEquals(true, result);

        result = r.isMatch("dabc", ".abc");
        assertEquals(true, result);

        result = r.isMatch("eabc", ".abc");
        assertEquals(true, result);

        result = r.isMatch("eabbbbc", ".ab*bc");
        assertEquals(true, result);

        result = r.isMatch("eabbbbc", ".ab*c");
        assertEquals(true, result);

        result = r.isMatch("eabbbcc", ".ab*c");
        assertEquals(false, result);

        result = r.isMatch("eabbbbc", ".ab*c");
        assertEquals(true, result);

        result = r.isMatch("eabbbbcccaaafff", ".ab*c*aa*fff");
        assertEquals(true, result);
    }
    @Test
    public void test1() {
        RegularExpressionMatching r = new RegularExpressionMatching();
        boolean result = r.isMatch("eabbbbcccaaafff", ".ab*c*aa*fff*");
        assertEquals(true, result);

        result = r.isMatch("eabbbbcccaaafff", ".*");
        assertEquals(true, result);

        result = r.isMatch("a", ".*");
        assertEquals(true, result);

        result = r.isMatch("aa", ".*");
        assertEquals(true, result);

        result = r.isMatch("aa", "a*");
        assertEquals(true, result);

        result = r.isMatch("aaa", "a*");
        assertEquals(true, result);

        result = r.isMatch("aa", "c*a*b*");
        assertEquals(true, result);

        result = r.isMatch("aab", "c*a*b*");
        assertEquals(true, result);

        result = r.isMatch("a", "c*.");
        assertEquals(true, result);
    }
    @Test
    public void test2() {
        RegularExpressionMatching r = new RegularExpressionMatching();
        boolean result = r.isMatch("ab", ".*");
        assertEquals(true, result);

        result = r.isMatch("sjdksjaljfkds", ".*");
        assertEquals(true, result);

        result = r.isMatch("aa", "a*a");
        assertEquals(true, result);

        result = r.isMatch("aa", "a*aa");
        assertEquals(true, result);

        result = r.isMatch("a", "a*a");
        assertEquals(true, result);

        result = r.isMatch("bbbba", ".*a*a");
        assertEquals(true, result);

        result = r.isMatch("a", "ab*");
        assertEquals(true, result);

        result = r.isMatch("", "c*c*");
        assertEquals(true, result);
    }
}
