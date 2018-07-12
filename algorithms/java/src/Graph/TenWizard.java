package Graph;

import java.util.*;

public class TenWizard {
    public List<Integer> getShortestPath(List<List<Integer>> wizards, int source, int target) {
        List<Integer> result = new LinkedList<>();
        int[] parent = new int[wizards.size()];
        parent[source] = source;
        int[][] matrix = new int[wizards.size()][wizards.size()];
        for(int i = 0; i < wizards.size(); i++) {
            for(int j = 0; j < wizards.get(i).size(); j++) {
                int v = wizards.get(i).get(j);
                matrix[i][v] = 1;
            }
        }
        int[] shortestPath = new int[wizards.size()]; // shortest path from [source, i]
        Arrays.fill(shortestPath, Integer.MAX_VALUE);
        shortestPath[source] = 0;
        PriorityQueue<Integer[]> q = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        q.add(new Integer[]{0, source});
        while (!q.isEmpty()) {
            Integer[] edge = q.poll();
            int s = edge[1];
            for (int i = 0; i < wizards.size(); i++) {
                // neighbors reachable && neighbors is unvisited
                if (matrix[s][i] > 0 && shortestPath[s] + weight(s, i) < shortestPath[i]) {
                    shortestPath[i] = shortestPath[s] + weight(s, i);
                    q.add(new Integer[]{shortestPath[i], i});
                    parent[i] = s;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int cur = target;
        while(parent[cur] != cur) { // find root(is source)
            result.add(0, cur);
            cur = parent[cur];
        }
        result.add(0, source);
        return result;
    }

    int weight(int i, int j) {
        int w = Math.abs(j - i);
        return w * w;
    }
}
