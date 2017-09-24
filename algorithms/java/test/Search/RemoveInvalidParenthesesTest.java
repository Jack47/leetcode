package Search;

import java.util.List;

import DepthFirstSearch.RemoveInvalidParentheses;
import org.junit.Test;

public class RemoveInvalidParenthesesTest {
    @Test
    public void test() {
        RemoveInvalidParentheses sol = new RemoveInvalidParentheses();
        List<String> result = sol.removeInvalidParentheses("()())()");
    }
}
