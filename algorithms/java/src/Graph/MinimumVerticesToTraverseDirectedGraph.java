package Graph;

import java.util.*;

public class MinimumVerticesToTraverseDirectedGraph {
    int[][] edges;
    boolean visited[];
    public List<Integer> getMin(int[][] edges, int n) {
        if(n == 0 || edges.length == 0) {
            return Collections.emptyList();
        }
        this.edges = edges;
        List<Integer> result = new LinkedList<>();
        visited = new boolean[n];
        int[]degree = new int[n];
        for(int[] edge : edges) {
            for(int j = 0; j < edge.length; j++) {
                if (edge[j] > 0) {
                    degree[j]++;
                }
            }
        }
        // 1. visit degree[] == 0

        for(int i = 0; i < n; i++) {
            if(degree[i] == 0) {
                result.add(i);
                bfs(i);
            }
        }
        // 2. visit cyclic graphs
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                result.add(i);
                bfs(i);
            }
        }
        return result;
    }
    void bfs(int i ) {
        Deque<Integer> q = new ArrayDeque<>();
        q.add(i);
        while(!q.isEmpty()) {
            int e = q.poll();
            if (visited[e]) {
                continue;
            }
            visited[e] = true;
            for(int j = 0; j <  edges[e].length; j++) {
                if(edges[e][j] > 0 && !visited[j]) {
                    q.add(j);
                }
            }
        }
    }
}
