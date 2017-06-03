package Trie;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WordDictionaryTest {
    @Test
    public void test() {
        WordDictionary wd = new WordDictionary();
        wd.addWord("ran");
        wd.addWord("rune");
        wd.addWord("runner");
        wd.addWord("runs");
        wd.addWord("add");
        wd.addWord("adds");
        wd.addWord("adder");
        wd.addWord("addee");

        boolean result = wd.search("r.n");
        assertEquals(true, result);

        result = wd.search("ru.n.e");
        assertEquals(false, result);


        result = wd.search("add");
        assertEquals(true, result);

        result = wd.search("add.");
        assertEquals(true, result);

        result = wd.search("adde.");
        assertEquals(true, result);

        result = wd.search(".an.");
        assertEquals(false, result);

        result = wd.search("...s");
        assertEquals(true, result);
        result = wd.search("....e.");
        assertEquals(true, result);

        result = wd.search(".......");
        assertEquals(false, result);

        result = wd.search("..n.r");
        assertEquals(false, result);

    }
}
