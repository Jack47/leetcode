package Combination;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ValidParenthesisTest {
    @Test
    public void test() {
        ValidParentheses validParentheses = new ValidParentheses();
        boolean result = validParentheses.isValid("(){}[]");
        assertEquals(true, result);

        result = validParentheses.isValid("");
        assertEquals(true, result);

        result = validParentheses.isValid("{(})[]");
        assertEquals(false, result);

        result = validParentheses.isValid("{}()[]]");
        assertEquals(false, result);

        result = validParentheses.isValid("({}[])");
        assertEquals(true, result);
    }
}
