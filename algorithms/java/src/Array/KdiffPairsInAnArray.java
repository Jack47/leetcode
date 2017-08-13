package Array;

import java.util.Arrays;

public class KdiffPairsInAnArray {
    public int findPairs(int[] nums, int k) {
        if(nums.length == 0) return 0;
        int count = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-1; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j=i+1; j < nums.length; j++) {
                if(nums[j]-nums[i] == k) {
                    count++;
                    break; // avoid duplicate
                } else if(nums[j] - nums[i] > k) {
                    break;
                }
            }
        }
        return count;
    }
}
