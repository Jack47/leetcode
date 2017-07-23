package Matrix;

import java.util.List;

import org.junit.Test;

public class SpiralMatrixTest {
    @Test
    public void test() {
        SpiralMatrix sp = new SpiralMatrix();
        List<Integer> l = sp.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});

        SpiralMatrixIIT s = new SpiralMatrixIIT();
        int[][] result = s.generateMatrix(3);
    }
}
