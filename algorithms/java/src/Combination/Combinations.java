package Combination;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations {
    List<List<Integer>> results;
    boolean[] visited;
    int k;
    int n;
    public List<List<Integer>> combine(int n, int k) {
        results = new LinkedList<>();
        this.k = k;
        this.n = n;
        visited = new boolean[n+1];
        dfs(1, k, new ArrayList<Integer>(k));
        return results;
    }
    void dfs(int s, int k, List<Integer> result) {
        if(k == 0){
            results.add(new ArrayList<>(result));
            return;
        }
        for(int i = s; i <= n; i++) {
            result.add(i);
            dfs(i+1, k-1, result);
            result.remove(result.size()-1);
        }
    }
}
