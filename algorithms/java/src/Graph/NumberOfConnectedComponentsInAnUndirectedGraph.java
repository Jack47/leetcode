package Graph;

public class NumberOfConnectedComponentsInAnUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for(int[] edge : edges) {
            int iRoot = findRoot(parent, edge[0]);
            int jRoot = findRoot(parent, edge[1]);
            if( iRoot != jRoot) { // can union
                parent[iRoot] = jRoot;
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(parent[i] == i) { // is root
                count++;
            }
        }
        return count;
    }

    int findRoot(int[] parent, int k) {
        while(parent[k] != k) {
            k = parent[k];
        }
        return k;
    }

    public int countComponentsDfs(int n, int[][] edges) {
       return 0;
    }
}
