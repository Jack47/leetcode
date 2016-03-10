package Combination;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class GenerateParenthesesTest {
    @Test
    public void test() {
        GenerateParenthesis generateParentheses = new GenerateParenthesis();
        List<String> resultList = generateParentheses.generateParenthesis(0);
        assertEquals(0, resultList.size());

        resultList = generateParentheses.generateParenthesis(1);
        assertEquals(1, resultList.size());
        assertEquals("()", resultList.get(0));

        resultList = generateParentheses.generateParenthesis(2);
        assertEquals(2, resultList.size());
        assertEquals("(())", resultList.get(0));
        assertEquals("()()", resultList.get(1));

        resultList = generateParentheses.generateParenthesis(3);
        assertEquals(5, resultList.size());
        assertEquals("((()))", resultList.get(0));
        assertEquals("(()())", resultList.get(1));
        assertEquals("(())()", resultList.get(2));
        assertEquals("()(())", resultList.get(3));
        assertEquals("()()()", resultList.get(4));

        resultList = generateParentheses.generateParenthesis(4);
        assertEquals(14, resultList.size());

        resultList = generateParentheses.generateParenthesis(5);
        assertEquals(42, resultList.size());
    }
}
