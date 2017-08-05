package Greedy;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class RemoveDuplicateLettersTest {
    @Test
    public void test() {
        RemoveDuplicateLetters r = new RemoveDuplicateLetters();
        String result = r.removeDuplicateLetters("bbcaac");
        assertEquals("bac", result);
    }
}
