package RegularExpression;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WildcardMatchingTest {
    @Test
    public void test () {
        WildcardMatching w = new WildcardMatching();
        boolean result = w.isMatch("abcd", "abcd");
        assertEquals(true, result);

        result = w.isMatch("abc", "abcd");
        assertEquals(false, result);

        result = w.isMatch("abcd", "abc");
        assertEquals(false, result);

        result = w.isMatch("aa", "*");
        assertEquals(true, result);

        result = w.isMatch("ab", "?*");
        assertEquals(true, result);

        result = w.isMatch("aab", "c*a*b");
        assertEquals(false, result);

        result = w.isMatch("zacabz", "*a?b*");
        assertEquals(false, result);

        result = w.isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba",
        "a*******b");
        assertEquals(false, result);
    }
}
