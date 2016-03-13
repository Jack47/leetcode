package AbsolutePath;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * https://leetcode.com/problems/simplify-path/
 * Corner Cases:
 * /../ => /
 * /home/a//search => /home/a/search
 */
public class SimplifyPath {
    protected final static String EmptyString = new String();
    protected final static String CurrentDir = ".";
    protected final static String ParentDir = "..";
    protected final static String SeparatorString = "/";
    protected final static String RootPath = SeparatorString;
    protected final static char SeparatorChar = '/';

    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<String>();
        int index = 0;
        String part = null;
        while (index < path.length()) {
            part = findNextPart(path, index);
            if (!part.isEmpty()) {
                if (part.compareTo(CurrentDir) == 0) {
                } else if (part.compareTo(ParentDir) == 0) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    stack.push(part);
                }
            }
            index += part.length() + 1;
        }

        StringBuilder result = new StringBuilder();
        Iterator<String> iter = stack.descendingIterator();

        if (stack.isEmpty()) return RootPath;

        while (iter.hasNext()) {
            result.append(SeparatorString + iter.next());
        }

        return result.toString();
    }

    protected static String findNextPart(final String path, int start) {
        int i = start;
        if (start >= path.length()) return EmptyString;
        assert path.charAt(i) == SeparatorChar;

        do {
            i++;
        }
        while (i < path.length() && path.charAt(i) != SeparatorChar);

        if (i - 1 < path.length() && (i > start + 1)) {
            return path.substring(start + 1, i);
        } else {
            return EmptyString;
        }
    }
}
