package AbsolutePath;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class SimplifyPathTest {
    @Test
    public void testFindNextPart() {
        String result = null;
        int start = 0;
        // Ordinary cases
        result = SimplifyPath.findNextPart("/home/a/search/", start);

        assertEquals("home", result);

        start = start + result.length() + 1;
        result = SimplifyPath.findNextPart("/home/a/search/", start);
        assertEquals("a", result);

        start = start + result.length() + 1;
        result = SimplifyPath.findNextPart("/home/a/search/", start);
        assertEquals("search", result);

        start = start + result.length() + 1;
        result = SimplifyPath.findNextPart("/home/a/search/", start);
        assertEquals("", result);

        // Corner cases
        start = 0;
        result = SimplifyPath.findNextPart("/././search/..", start);
        assertEquals(".", result);

        start = start + result.length() + 1;
        result = SimplifyPath.findNextPart("/././search/..", start);
        assertEquals(".", result);

        start = start + result.length() + 1;
        result = SimplifyPath.findNextPart("/././search/..", start);
        assertEquals("search", result);

        start = start + result.length() + 1;
        result = SimplifyPath.findNextPart("/././search/..", start);
        assertEquals("..", result);
    }

    @Test
    public void testSimplify() {
        SimplifyPath simplifyPath = new SimplifyPath();
        // Ordinary cases
        String path = "/home/../a/s/.";
        String result = simplifyPath.simplifyPath(path);
        assertEquals("/a/s", result);

        path = "/./home/abc/sss/";
        result = simplifyPath.simplifyPath(path);
        assertEquals("/home/abc/sss", result);

        // Corner cases
        path = "/home\\//a/search/../../../";
        result = simplifyPath.simplifyPath(path);
        assertEquals("/", result);

        path = "/../../../";
        result = simplifyPath.simplifyPath(path);
        assertEquals("/", result);

        path = "/home//a/";
        result = simplifyPath.simplifyPath(path);
        assertEquals("/home/a", result);
    }
}
