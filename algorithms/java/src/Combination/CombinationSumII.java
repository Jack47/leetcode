package Combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumII {
    List<List<Integer>> results;
    int[] candidates;
    void dfsON(int i, int target, List<Integer> result) {
        if(target == 0) {
            // must stop immediately,
            // else will generate duplicate items in results
            results.add(new ArrayList<>(result));
            return;
        }
        if(i == candidates.length) {
            return;
        }
        if(target >= candidates[i]) {
            result.add(candidates[i]);
            dfs(i+1, target-candidates[i], result);
            result.remove(result.size()-1);
        }
        if(result.size() == 0 || result.get(result.size()-1) != candidates[i]) {
            dfs(i+1, target, result);
        }
    }

    // form target in [i..]
    void dfs(int i, int target, List<Integer> result) {
        if(target == 0) {
            results.add(new ArrayList<>(result));
            return; // meaningless to continue
        }
        if(i == candidates.length) {
            return;
        }
        // n-i different possibilities
        for(int k = i; k < candidates.length; k++) {
            if (candidates[k] < target) break;
            result.add(candidates[k]);
            dfs(k+1, target-candidates[k], result);
            result.remove(result.size()-1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        results = new LinkedList<>();
        this.candidates = candidates;
        dfs(0, target, new ArrayList<>(candidates.length));
        return results;
    }
}
