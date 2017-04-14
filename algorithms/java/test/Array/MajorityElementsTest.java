package Array;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MajorityElementsTest {
    @Test
    public void test() {
        MajorityElements m = new MajorityElements();
        List<Integer> result = m.majorityElement(new int[]{
                1,2,2,3,2,1,1,3
        });
        assertEquals(new ArrayList<Integer>(){
            {
                add(1);
                add(2);
            }
        }, result);
    }
}
