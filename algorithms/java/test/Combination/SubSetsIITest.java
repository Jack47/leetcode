package Combination;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SubSetsIITest {
    @Test
    public void test() {
        SubSetsII subSets = new SubSetsII();
        List<List<Integer>> result = subSets.subsetsWithDup(new int[]{1, 2, 2});
        assertEquals(6, result.size());
        assertEquals(new ArrayList<Integer>(), result.get(0));
        assertEquals(new ArrayList<Integer>() {{
            add(2);
        }}, result.get(1));
        assertEquals(new ArrayList<Integer>() {{
            add(2);
            add(2);
        }}, result.get(2));
        assertEquals(new ArrayList<Integer>() {{
            add(1);
        }}, result.get(3));

        assertEquals(new ArrayList<Integer>() {{
            add(1);
            add(2);
        }}, result.get(4));

        assertEquals(new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(2);
        }}, result.get(5));
    }
}
