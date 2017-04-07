package Array;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FindAllDuplicatesTest {
    @Test
    public void test() {
        FindAllDuplicates sol = new FindAllDuplicates();
        List<Integer> result = sol.findDuplicates(new int[]{4,3,2,7,8,2,3,1});
        assertEquals(new ArrayList<Integer>(){
            {
                add(2);
                add(3);
            }
        }, result);

        result = sol.findDuplicates(new int[]{4,3,2,5,6,1});
        assertEquals(new ArrayList<Integer>(), result);

        result = sol.findDuplicates(new int[]{});
        assertEquals(new ArrayList<Integer>(), result);
    }
}
