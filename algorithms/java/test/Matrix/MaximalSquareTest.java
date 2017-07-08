package Matrix;

import org.junit.Test;

public class MaximalSquareTest {
    @Test
    public void test() {
        MaximalSquare s = new MaximalSquare();
        s.maximalSquareE(new char[][]{{'1', '0', '1', '0'}, {'1', '0', '1', '1'}, {'1',
                '0', '1', '1'}, {'1', '1', '1', '1'}});

    }
}
