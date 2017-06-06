package NumberOfIslands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/number-of-islands-ii/#/description
//
public class NumberOfIslandsII {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<Integer>();
        if (m == 0 || n == 0) return result;

        int[] roots = new int[m*n];
        Arrays.fill(roots, -1);
        int count = 0;
        for(int i = 0; i < positions.length; i++) {
            count++;
            int root = positions[i][0]*n + positions[i][1];
            roots[root] = root;

            for (int k = 0; k < 4; k++) {
                int ii = positions[i][0];
                int jj = positions[i][1];
                switch (k) {
                    case 0:
                        ii++;break;
                    case 1:
                        ii--;break;
                    case 2:
                        jj++;break;
                    case 3:
                        jj--;break;
                }
                int nb = ii*n + jj;
                if (ii >= 0 && ii < m &&
                        jj >= 0 && jj < n &&
                        roots[nb] != -1) {
                    int rootNb = findRoot(roots, nb);
                    if (rootNb >= 0 && rootNb != root) {
                        count--;
                        roots[root] = rootNb;
                        root = rootNb;
                    }
                }
            }
            result.add(count);
        }
        return result;
    }
    int findRoot(int[] roots, int n) {
        while(n >= 0 && roots[n] != n) n = roots[n];
        return n;
    }
}
