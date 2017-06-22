package Sum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class kSum {
    public List<List<Integer>> kSum(int[] nums, int target, int k, int start) {
        if (nums == null || k > nums.length - start) {
            return Collections.emptyList();
        }
        if (nums[nums.length - 1] * k < target || nums[start] * k > target) {
            return Collections.emptyList();
        }
        List<List<Integer>> results = new ArrayList<List<Integer>>();

        if (k == 2) {
            int s = start;
            int e = nums.length - 1;
            List<Integer> result = new ArrayList<Integer>(2);
            while (s < e) {
                if (s > start && nums[s] == nums[s - 1]) {
                    s++;
                    continue;
                }
                if (e < nums.length - 1 && nums[e] == nums[e + 1]) {
                    e--;
                    continue;
                }
                if (nums[s] + nums[e] > target) {
                    e--;
                } else if (nums[s] + nums[e] < target) {
                    s++;
                } else {
                    result.add(nums[s]);
                    result.add(nums[e]);
                    results.add(result);
                    result.clear();
                    s++;
                }
            }
        } else {
            for (int i = start; i < nums.length - k; i++) {
                if (k * nums[i] > target) break;
                if (i > start && nums[i] == nums[i - 1]) continue;
                List<List<Integer>> result = kSum(nums, target - nums[i], k - 1, i + 1);
                if (!result.isEmpty()) {
                    for (List<Integer> r : result) {
                        r.add(nums[i]);
                        results.add(r);
                    }
                }
            }
        }
        return results;
    }
}
