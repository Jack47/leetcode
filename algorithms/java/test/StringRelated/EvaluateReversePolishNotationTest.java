package StringRelated;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EvaluateReversePolishNotationTest {
    @Test
    public void test() {
        EvaluateReversePolishNotation ev = new EvaluateReversePolishNotation();
        int result = ev.evalRPN(new String[]{"22", "11", "+", "13", "*"});
        assertEquals(429, result);

        result = ev.evalRPN(new String[]{"4", "13", "5", "/", "+"});
        assertEquals(6, result);
    }
}
