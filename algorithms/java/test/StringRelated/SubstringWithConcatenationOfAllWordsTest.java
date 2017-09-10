package StringRelated;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class SubstringWithConcatenationOfAllWordsTest {
    @Test
    public void test() {
        SubstringWithConcatenationOfAllWords s = new SubstringWithConcatenationOfAllWords();
        List<Integer> real = s.findSubstring(new String("barfoothefoobarman"),
                new String[]{"foo", "bar"});
        assertEquals(new int[]{0, 9}, real);
    }
}
