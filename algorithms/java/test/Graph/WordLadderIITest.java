package Graph;

import java.util.ArrayList;

import org.junit.Test;

public class WordLadderIITest {
    @Test
    public void test() {
        WordLadderIIT l = new WordLadderIIT();
        l.findLadders("hit", "cog", new ArrayList<String>(){{
            add("hot");
            add("dot");
            add("dog");
            add("lot");
            add("log");
            add("cog");
        }});
    }
}
