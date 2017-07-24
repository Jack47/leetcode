package Sum;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int sum = 0;
        int delta = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            int l = i+1, r = nums.length-1;
            while(l < r) {
                int s = nums[i] + nums[l] + nums[r];
                if(Math.abs(target-s) < delta) {
                    delta = Math.abs(target-s);
                    sum = s;
                }
                if(s > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return sum;
    }
}
