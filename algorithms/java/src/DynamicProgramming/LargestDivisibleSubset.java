package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums.length == 0) return Collections.emptyList();
        int[] count = new int[nums.length];
        int[] pre = new int[nums.length];
        Arrays.fill(pre, -1);
        int maxEnd = 0;
        for (int i = 0; i < nums.length; i++) {
            count[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && count[j] + 1 > count[i]) {
                    count[i] = count[j] + 1;
                    pre[i] = j;
                }
            }
            if (count[i] > count[maxEnd]) {
                maxEnd = i;
            }
        }
        int e = maxEnd;
        while (e != -1) {
            result.add(0, nums[e]);
            e = pre[e];
        }
        return result;
    }
}
