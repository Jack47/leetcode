package Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return Collections.emptyList();
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > 0) break;
            int s = i + 1;
            int e = nums.length - 1;
            while (s < e) {
                if (nums[s] + nums[e] > -nums[i]) {
                    e--;
                } else if (nums[s] + nums[e] < -nums[i]) {
                    s++;
                } else {
                    List<Integer> result = new ArrayList<Integer>(3);
                    result.add(nums[i]);
                    result.add(nums[s]);
                    result.add(nums[e]);
                    results.add(result);
                    do {
                        s++;
                    } while (s < e && nums[s] == nums[s - 1]);
                }
            }
        }
        return results;
    }
}
