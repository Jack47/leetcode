package UnionFind;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/number-of-islands-ii/#/description
//
public class NumberOfIslandsII {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] roots = new int[m * n];
        int count = 0;
        int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        List<Integer> result = new ArrayList<>();
        for (int k = 0; k < positions.length; k++) {
            count++;
            int i = positions[k][0];
            int j = positions[k][1];
            int pos = i * m + j;
            roots[pos] = pos; // init parent as self;
            // visit neighbors
            int root = roots[pos];
            for (int[] dir : dirs) {
                int ii = i + dir[0];
                int jj = j + dir[1];
                // can merge
                if (ii >= 0 && ii < m && jj >= 0 && jj < n && roots[ii*m+jj] != -1) {
                    int nbRoot = findRoot(roots, ii*m+jj);
                    if(root != nbRoot) {
                        roots[root] = nbRoot;
                        root = nbRoot; // now try to merge the new root
                        count--;
                    }
                }
            }
            result.add(count);
        }
        return result;
    }
    int findRoot(int[] roots, int n) {
        while(roots[n] != n) {
            n = roots[n];
        }
        return n;
    }
}
