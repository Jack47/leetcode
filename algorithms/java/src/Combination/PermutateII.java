package Combination;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PermutateII {
    List<List<Integer>> results;
    boolean[] visited;
    int[] nums;
    public List<List<Integer>> permuteUnique(int[] nums) {
        results = new LinkedList<>();
        visited = new boolean[nums.length];
        this.nums = nums;
        dfs(0, new ArrayList<>(nums.length));
        return results;
    }
    // iterate all permutations starting from pos i
    void dfs(int i, List<Integer> result) {
        if(result.size() == nums.length) {
            results.add(new ArrayList<>(result));
        }
        if(i == nums.length) { // maybe result.size() <= nums.length
            return;
        }
        for(int k = 0; k < nums.length; k++) {
            if(!visited[k] ){
                visited[k] = true;
                result.add(nums[k]);
                dfs(i+1, result);
                result.remove(result.size()-1);
                visited[k] = false;
            }
        }
    }
}
