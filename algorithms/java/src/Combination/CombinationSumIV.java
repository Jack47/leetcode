package Combination;

import java.util.Arrays;

public class CombinationSumIV {
    int[] nums;
    int count;
    int[] cache;
    int dfs(int target) {
        if(cache[target] != -1) return cache[target];
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > target) break;
            if(target-nums[i] == 0) {
                count++;
            } else {
                count += dfs(target-nums[i]);
            }
        }
        cache[target] = count;
        return count;
    }
    public int combinationSum4(int[] nums, int target) {
        this.nums = nums;
        this.count = 0;
        Arrays.sort(nums);
        cache = new int[target+1];
        Arrays.fill(cache, -1);
        return dfs(target);
    }
}
