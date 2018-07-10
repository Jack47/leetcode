package DepthFirstSearch;

import org.junit.Test;

import java.util.List;

public class NumberOfIslandsIITest {
    @Test
    public void test() {
        NumberOfIslandsIIT ii = new NumberOfIslandsIIT();
        List<Integer> islands = ii.numIslands2(3, 7, new int[][]{
                {1,6},{0,4},{2,3},{1,2},{1,1},{2,4 }
        });

    }
}
