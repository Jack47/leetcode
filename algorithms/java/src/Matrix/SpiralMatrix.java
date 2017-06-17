package Matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix == null) return Collections.emptyList();
        int totalLen = matrix.length * matrix[0].length;
        List<Integer> ret = new ArrayList<Integer>(totalLen);

        int count = 0;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int i = 0, j = -1;
        int d = 0;
        while (count < totalLen) {
            int ii = i;
            int jj = j;
            switch (d) { // designs the spiral direction
                case 0:
                    jj++;
                    break;
                case 1:
                    ii++;
                    break;
                case 2:
                    jj--;
                    break;
                case 3:
                    ii--;
                    break;
            }

            if (ii < 0 || ii >= matrix.length || jj < 0 || jj >= matrix[0].length || visited[ii][jj]) {
                d = d + 1 <= 3 ? d + 1 : 0;
            } else {
                i = ii;
                j = jj;
                visited[i][j] = true;
                ret.add(matrix[i][j]);
                count++;
            }
        }
        return ret;
    }
}
