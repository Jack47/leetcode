package Graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MinimumVerticesToTraverseDirectedGraphTest {
    @Test
    public void test() {
        MinimumVerticesToTraverseDirectedGraph mvt = new MinimumVerticesToTraverseDirectedGraph();
        int[][] edges = new int[][]{
                {0, 1, 0, 0},
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 2, 0},
        };
        List<Integer> real = mvt.getMin(edges, 4);
        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        assertEquals(expected, real);
    }
}
