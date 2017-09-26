package UnionFind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfIslandsIIT {
    int[] roots;
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        roots = new int[m * n];
        Arrays.fill(roots, -1);
        int count = 0;
        List<Integer> result = new ArrayList<>();
        for (int[] position : positions) {
            int i = position[0];
            int j = position[1];
            int root = i * m + j; // two dimension -> one dimension
            count++;
            // try to unite neighbors
            for (int[] dir : dirs) {
                int ni = i + dir[0];
                int nj = j + dir[1];
                int pos = ni * m + nj;

                if (ni >= 0 && ni <= m - 1 &&
                        nj >= 0 && nj <= n - 1 &&
                        roots[pos] != -1) { // neighbor exist and not empty land
                    int nbRoot = findRoot(pos);
                    if (root != nbRoot) {
                        roots[root] = nbRoot; // union to nbRoot
                        root = nbRoot;
                        count--;
                    }
                }
            }
            result.add(count);
        }
        return result;
    }

    int findRoot(int pos) {
        if (roots[pos] != pos) {
            roots[pos] = findRoot(roots[pos]);
        }
        return roots[pos];
    }
}
