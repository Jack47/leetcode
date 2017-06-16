package StringRelated;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class ValidAnagramTest {
    @Test
    public void test() {
        ValidAnagram v =new ValidAnagram();
        boolean result = v.isAnagram("anagram", "nagaram");
        assertEquals(true, result);
    }
}
