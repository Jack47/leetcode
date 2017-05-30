package StringRelated;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TextJustificationTest {
    @Test
    public void test() {
        TextJustification tj = new TextJustification();
        String[] words = new String[]{"This", "is", "an", "example", "of", "text",
                "justification."};
        List<String> result = tj.fullJustify(words, 16);
        List<String> expected = new ArrayList<String>() {
            {
                add("This    is    an");
                add("example  of text");
                add("justification.  ");
            }
        };
        assertEquals(expected, result);

        words = new String[]{"a","b","c","d","e"};
        result = tj.fullJustify(words, 16);
        expected = new ArrayList<String>() {
            {
                add("a b c d e       ");
            }
        };
        assertEquals(expected, result);

        result = tj.fullJustify(words, 1);
        expected = new ArrayList<String>() {
            {
                add("a");
                add("b");
                add("c");
                add("d");
                add("e");
            }
        };
        assertEquals(expected, result);

        result = tj.fullJustify(words, 2);
        expected = new ArrayList<String>() {
            {
                add("a ");
                add("b ");
                add("c ");
                add("d ");
                add("e ");
            }
        };
        assertEquals(expected, result);

        words = new String[]{"Listen","to","many","speak","to","a","few."};
        result = tj.fullJustify(words, 6);
        expected = new ArrayList<String>() {
            {
                add("Listen");
                add("to    ");
                add("many  ");
                add("speak ");
                add("to   a");
                add("few.  ");
            }
        };
        assertEquals(expected, result);

        words = new String[]{"Don't","go","around","saying","the","world","owes","you","a","living;","the","world","owes","you","nothing;","it","was","here","first."};
        result = tj.fullJustify(words, 30);
        expected = new ArrayList<String>() {
            {
                add("Don't  go  around  saying  the");
                add("world  owes  you a living; the");
                add("world owes you nothing; it was");
                add("here first.                   ");
            }
        };
        assertEquals(expected, result);
    }
}
