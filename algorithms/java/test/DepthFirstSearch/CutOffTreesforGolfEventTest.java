package DepthFirstSearch;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CutOffTreesforGolfEventTest {
    @Test
    public void test() {
        CutOffTreesforGolfEvent c = new CutOffTreesforGolfEvent();
        List<List<Integer>> forest = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        row.add(8);
        row.add(2);
        row.add(3);
        forest.add(row);

        row = new ArrayList<>();
        row.add(0);
        row.add(0);
        row.add(4);
        forest.add(row);

        row = new ArrayList<>();
        row.add(7);
        row.add(6);
        row.add(5);
        forest.add(row);

        int r = c.cutOffTree(forest);
        assertEquals(12, r);
    }
}
