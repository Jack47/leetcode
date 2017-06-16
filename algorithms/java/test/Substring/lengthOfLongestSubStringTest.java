package Substring;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class lengthOfLongestSubStringTest {
    @Test
    public void test() {
        lengthOfLongestSubstring l = new lengthOfLongestSubstring();
        int result = l.lengthOfLongestSubstring("abcabcbb");
        assertEquals(3, result);
        result = l.lengthOfLongestSubstring("tmmzuxt");
        assertEquals(5, result);
    }

}
