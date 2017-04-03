package Array;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FindAllDisappearedNumbersTest {
    @Test
    public void test() {
        FindAllDisappearedNumber sol = new FindAllDisappearedNumber();
        List<Integer> result = sol.findDisappearedNumbers(new int[]{1,2,3,4,5,4});
        assertEquals(new ArrayList<Integer>() {{
            add(6);
        }}, result);

        result = sol.findDisappearedNumbers(new int[]{2,2,3,4,5,4});
        assertEquals(new ArrayList<Integer>() {{
            add(1);
            add(6);
        }}, result);

        result = sol.findDisappearedNumbers(new int[]{});
        assertEquals(new ArrayList<Integer>(), result);

        result = sol.findDisappearedNumbers(new int[]{1, 2});
        assertEquals(new ArrayList<Integer>(), result);
    }
}
