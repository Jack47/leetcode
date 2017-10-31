package StringRelated;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class StringCompressionTest {
    @Test
    public void test() {
        StringCompression s = new StringCompression();
        int real = s.compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'});
        assertEquals(6, real);
    }
}
