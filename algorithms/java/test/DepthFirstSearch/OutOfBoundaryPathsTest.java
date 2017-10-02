package DepthFirstSearch;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OutOfBoundaryPathsTest {
    @Test
    public void test() {
        OutOfBoundaryPaths o = new OutOfBoundaryPaths();
        int real = o.findPaths(2, 2, 2, 0, 0);
        assertEquals(6, real);
    }
}
