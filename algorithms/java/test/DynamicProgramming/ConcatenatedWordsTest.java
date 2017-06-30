package DynamicProgramming;

import java.util.List;

import org.junit.Test;

public class ConcatenatedWordsTest {
    @Test
    public void test() {
        ConcatenatedWordsEnhancement sol = new ConcatenatedWordsEnhancement();
        List<String> result = sol.findAllConcatenatedWordsInADict(new String[]{"cat", "cats", "catsdogcats", "dog",
                "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"});

    }
}
