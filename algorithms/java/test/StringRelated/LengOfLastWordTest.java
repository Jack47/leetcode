package StringRelated;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class LengOfLastWordTest {
    @Test
    public void test() {
        LengthOfLastWord lengOfLastWord = new LengthOfLastWord();
        int result = lengOfLastWord.lengthOfLastWord("num");
        assertEquals(3, result);

        result = lengOfLastWord.lengthOfLastWord("hello World!");
        assertEquals(6, result);

        result = lengOfLastWord.lengthOfLastWord(" ");
        assertEquals(0, result);

        result = lengOfLastWord.lengthOfLastWord("a ");
        assertEquals(1, result);
    }
}
