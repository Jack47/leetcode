package Graph;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AlienDictionaryTTTest {
    @Test
    public void test() {
        AlienDictionaryTT ald = new AlienDictionaryTT();
        String s = ald.alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"});
        assertEquals(s, "wertf");
    }
}
