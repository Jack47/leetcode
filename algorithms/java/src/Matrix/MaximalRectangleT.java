package Matrix;

import java.util.Stack;

public class MaximalRectangleT {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int max = 0;
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        int[] h = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            int j;
            for (j = 0; j < matrix[i].length; j++) {
                int up = i == 0 ? 0 : h[j];
                h[j] = matrix[i][j] == '0' ? 0 : up + 1;
                if (s.size() == 1 || h[j] >= h[s.peek()]) {
                    s.push(j);
                } else {
                    while (s.size() > 1 && h[j] < h[s.peek()]) {
                        int height = h[s.pop()];
                        max = Math.max(max, height * (j - s.peek() - 1));
                    }
                    s.push(j);
                }
            }
            while (s.size() > 1) {
                int height = h[s.pop()];
                max = Math.max(max, height * (j - s.peek() - 1));
            }
        }
        return max;
    }
}
