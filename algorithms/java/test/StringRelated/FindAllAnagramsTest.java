package StringRelated;

import static junit.framework.TestCase.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FindAllAnagramsTest {
    @Test
    public void test() {
        FindAllAnagramsT sol = new FindAllAnagramsT();
        List<Integer> result = sol.findAnagrams("cbaebabacd", "abc");
        assertEquals(new ArrayList<Integer>(){
            {
                add(0);
                add(6);
            }
        }, result);
    }
}
