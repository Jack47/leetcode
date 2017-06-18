package StringRelated;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class ReverseWordsTest {
    @Test
    public void test() {
        ReverseWordsInAString rs = new ReverseWordsInAString();
        String result = rs.reverseWords(" this is a  skylark ");
        assertEquals("skylark a is this", result);
    }
}
