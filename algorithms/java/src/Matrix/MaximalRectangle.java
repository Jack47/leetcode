package Matrix;

import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int max = 0;
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] h = new int[n];
        int width = 0;
        for(int i = 0; i < n; i++) {
            h[i] = matrix[0][i] == '1' ? 1 : 0;
            if(h[i] == '1') {
                width++;
            } else {
                width = 0;
            }
            max = Math.max(max, width);
        }

        Stack<Integer> s = new Stack<>();
        s.push(-1);
        for(int i = 1; i < m; i++) {
            int j;
            for(j = 0;j < n;j++) {
               h[j] = matrix[i][j] == '1' ? 1 + h[j] : 0;
               if(s.size() == 1 || h[j]>= h[s.peek()]) {
                   s.push(j);
               } else {
                   while(s.size() > 1 && h[j] < h[s.peek()]) {
                       int height = h[s.pop()];
                       int w = j - s.peek()-1;
                       max = Math.max(height*w, max);
                   }
                   s.push(j);
               }
            }
            while(s.size() > 1) {
                int height = h[s.pop()];
                int w = j - s.peek()-1;
                max = Math.max(height*w, max);
            }
        }
        return max;
    }
}
