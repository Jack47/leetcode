package UnionFind;

public class RedundantConnection {
    int[] roots;

    void initUnion(int n) {
        roots = new int[n];
        for (int i = 1; i <= n - 1; i++) {
            roots[i] = i;
        }
    }

    int findRoot(int pos) {
        if (roots[pos] != pos) {
            // path compression
            roots[pos] = findRoot(roots[pos]);
        }
        return roots[pos];
    }

    void unite(int end, int parent) {
        roots[end] = parent;
    }

    public int[] findRedundantConnection(int[][] edges) {
        initUnion(2001);
        for (int[] edge : edges) {
            int parent = edge[0];
            int end = edge[1];
            if (findRoot(parent) == findRoot(end)) {
                return edge;
            }
            unite(findRoot(end), findRoot(parent));
        }
        return null;
    }
}
