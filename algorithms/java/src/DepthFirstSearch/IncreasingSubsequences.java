package DepthFirstSearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequences {
    List<Integer> cur;
    List<List<Integer>> result;
    int[] nums;
    // choose nums[i..n] to form a subsequence
    void dfs(int i) {
        if (cur.size() >= 2) {
            result.add(new ArrayList<>(cur));
        }
        if (i == nums.length) return;
        Set<Integer> set = new HashSet<>();
        for (int k = i; k < nums.length; k++) {

            if (!set.contains(nums[k]) && (cur.size() == 0 ||
                    cur.get(cur.size() - 1) <= nums[k])) {
                set.add(nums[k]);
                cur.add(nums[k]);
                dfs(k + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        cur = new ArrayList<>();
        result = new ArrayList<>();
        this.nums = nums;
        // start from beginning to choose one element.
        dfs(0);
        return result;
    }
}
