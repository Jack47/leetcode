package RegularExpression;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RegularExpressionMatchingTTest {
    @Test
    public void test() {
        RegularExpressionMatchingT remt = new RegularExpressionMatchingT();
        boolean match = remt.isMatch("ab", ".*..");
        assertEquals(true, match);

        match = remt.isMatch("ab", ".*c");
        assertEquals(false, match);
    }
}
