package DepthFirstSearch;

import java.util.List;

import org.junit.Test;

public class RemoveInvalidParenthesesTTest {
    @Test
    public void test() {
        RemoveInvalidParenthesesT t = new RemoveInvalidParenthesesT();
        List<String> s = t.removeInvalidParentheses("())");
        s = t.removeInvalidParentheses("(j))(");
    }
}
