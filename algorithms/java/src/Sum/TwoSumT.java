package Sum;

import java.util.Arrays;

public class TwoSumT {
    public int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length -1;
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);
        while(l < r) {
            if(sortedNums[l]+sortedNums[r] > target) {
                r--;
            } else if(sortedNums[l]+sortedNums[r] < target) {
                l++;
            } else {
                break;
            }
        }

        int left = -1, right = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == sortedNums[l] && left == -1) {
                left = i;
            }
            if(nums[i] == sortedNums[r] && right == -1 && left != i) {
                right = i;
                break;
            }
        }
        return new int[]{left, right};
    }
}
