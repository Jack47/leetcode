package BinaryIndexedTree;

import static junit.framework.TestCase.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CountOfSmallerNumbersAfterSelfTest {
    @Test
    public void test() {
        CountOfSmallerNumbersAfterSelfT sol = new CountOfSmallerNumbersAfterSelfT();
        List<Integer> result = sol.countSmaller(new int[]{-1, -1});
        assertEquals(new ArrayList<Integer>(){{
            add(0);
            add(0);
        }}, result);

        result = sol.countSmaller(new int[]{5, 2, 6, 1});
        assertEquals(new ArrayList<Integer>(){{
            add(2);
            add(1);
            add(1);
            add(0);
        }}, result);
    }
}
