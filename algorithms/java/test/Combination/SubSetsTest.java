package Combination;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SubSetsTest {
    @Test
    public void test() {
        SubSets subSets = new SubSets();
        List<List<Integer>> resultList = subSets.subsets(new int[]{3, 2, 1});
        assertEquals(8, resultList.size());
        assertEquals(new ArrayList<Integer>(){{}}, resultList.get(0));
        assertEquals(new ArrayList<Integer>(){{add(1);}}, resultList.get(1));
        assertEquals(new ArrayList<Integer>(){{add(2);}}, resultList.get(2));
        assertEquals(new ArrayList<Integer>(){{add(1);add(2);}}, resultList.get(3));
        assertEquals(new ArrayList<Integer>(){{add(3);}}, resultList.get(4));
        assertEquals(new ArrayList<Integer>(){{add(1);add(3);}}, resultList.get(5));
        assertEquals(new ArrayList<Integer>(){{add(2);add(3);}}, resultList.get(6));
        assertEquals(new ArrayList<Integer>(){{add(1);add(2);add(3);}}, resultList.get(7));
    }
}
