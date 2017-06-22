package BinaryTree;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class ClosestBinarySearchTreeValueTest {
    @Test
    public void test () {
        ClosestBinarySearchTreeValue sol = new ClosestBinarySearchTreeValue();
        assertEquals(true, sol.closer(3.142, 3, 4));
        assertEquals(false, sol.closer(3.142, 4, 3));
    }
}
