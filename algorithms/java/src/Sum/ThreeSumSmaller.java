package Sum;

import java.util.Arrays;

public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        int num = 0;
        if(nums.length <= 2) return num;
        Arrays.sort(nums);

        for(int i = 0; i < nums.length-2; i++) {
            int l = i+1, r = nums.length-1;
            while(l < r) {
                if(nums[i] + nums[l] + nums[r] < target) {
                    num += r-l;
                    l++;
                } else {
                    r--;
                }
            }
        }
        return num;
    }
}
