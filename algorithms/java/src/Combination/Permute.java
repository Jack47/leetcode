package Combination;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    void permute(int[] nums, int n) {
        if (n < 0) {
            List<Integer> r = new ArrayList<Integer>(result.length);
            for (int num : result) {
                r.add(num);
            }
            results.add(r);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                result[n] = nums[i];
                permute(nums, n - 1);
                visited[i] = false;
            }
        }
    }

    List<List<Integer>> results = new ArrayList<List<Integer>>();
    int[] result;
    boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        result = new int[nums.length];
        visited = new boolean[nums.length];

        permute(nums, nums.length - 1);
        return results;
    }
}
