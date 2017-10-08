package DepthFirstSearch;

import org.junit.Test;

public class NumberOfDistinctIslandsTest {
    @Test
    public void test() {
        NumberOfDistinctIslands n = new NumberOfDistinctIslands();
        n.numDistinctIslands(new int[][]{{1,1,0,0},{1,1,0,0},{0,0,1,1},{0,0,0,1}});
    }
}
