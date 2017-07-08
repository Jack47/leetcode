package Matrix;

import org.junit.Test;

public class MaximalRectangleTest {
    @Test
    public void test() {
        MaximalRectangle mr = new MaximalRectangle();
        int max = mr.maximalRectangle(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}});
    }
}
