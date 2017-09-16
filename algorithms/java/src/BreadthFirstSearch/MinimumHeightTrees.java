package BreadthFirstSearch;

import java.util.*;

public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) return Collections.singletonList(0);
        List<HashSet<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.set(i, new HashSet<>());
        }

        // construct adjacent vertex
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i <= n - 1; i++) {
            if (adj.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        while (n > 2) {
            int size = leaves.size();
            n -= size;
            while (size > 0) {
                Integer leaf = leaves.poll();
                int j = adj.get(leaf).iterator().next();
                adj.get(j).remove(leaf);
                if(adj.get(j).size() == 1) {
                    leaves.offer(j);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        result.addAll(leaves);
        return result;
    }
}
