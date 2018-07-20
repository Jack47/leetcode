package RegularExpression;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WildcardMatchingTTest {
    @Test
    public void test() {
        WildCardMatchingT wcmt = new WildCardMatchingT();
        boolean match = wcmt.isMatch("cb","?a");
        assertEquals(false, match);


        match = wcmt.isMatch("acdcb","a*c?b");
        assertEquals(false, match);

        match = wcmt.isMatch("adceb","*a*b");
        assertEquals(true, match);

        match = wcmt.isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba","a*******b");
        assertEquals(false, match);
    }
}
