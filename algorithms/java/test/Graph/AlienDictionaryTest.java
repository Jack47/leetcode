package Graph;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AlienDictionaryTest {
    @Test
    public void test() {
        AlienDictionaryT d = new AlienDictionaryT();
        String[] words = new String[] {"z", "z"};
        String result = d.alienOrder(words);
        assertEquals("z", result);

        String[] w2 = new String[] {"z", "zx"};
        result = d.alienOrder(w2);
        assertEquals("xz", result);

        String[] w1 = new String[] {"zy", "zx"};
        result = d.alienOrder(w1);
        assertEquals("yzx", result);

        w1 = new String[] {"ac", "ab", "b"};
        result = d.alienOrder(w1);
        assertEquals("acb", result);

        w1 = new String[]{"za","zb","ca","cb"};
        result = d.alienOrder(w1);
        assertEquals("azbc", result);

        w1 = new String[]{"ri","xz","qxf","jhsguaw","dztqrbwbm","dhdqfb","jdv","fcgfsilnb","ooby"};
        result = d.alienOrder(w1);
        assertEquals("", result);
    }
}
