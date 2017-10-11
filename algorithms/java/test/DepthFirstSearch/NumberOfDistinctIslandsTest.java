package DepthFirstSearch;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NumberOfDistinctIslandsTest {
    @Test
    public void test() {
        NumberOfDistinctIslands n = new NumberOfDistinctIslands();
        int real = n.numDistinctIslands(new int[][]{{1,1,0,0},{1,1,0,0},{0,0,1,1},{0,0,0,1}});
        assertEquals(real, 2);
    }
}
