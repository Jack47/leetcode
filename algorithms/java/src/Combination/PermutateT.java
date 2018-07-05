package Combination;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PermutateT {
    List<List<Integer>> results;
    boolean[] visited;
    int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        results = new LinkedList<>();
        visited = new boolean[nums.length];
        this.nums = nums;
        dfs(0, new ArrayList<>(nums.length));
        return results;
    }
    // iterate all permutations starting from pos i
    // NOTICE: we can delete i from input parameter, because every elements must in result
    // so we don't need to limit the step by i. Or i can be substitude by result.size()
    void dfs(int i, List<Integer> result) {
        if(i == nums.length) { // result.length == nums.length
            // because every time i+1, element is added to result
            results.add(new ArrayList<>(result));
            return;
        }
        for(int k = 0; k < nums.length; k++) {
            if(!visited[k]) {
                visited[k] = true;
                result.add(nums[k]);
                dfs(i+1, result);
                result.remove(result.size()-1);
                visited[k] = false;
            }
        }
    }
}
