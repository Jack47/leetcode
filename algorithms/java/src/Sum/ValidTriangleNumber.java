package Sum;

import java.util.Arrays;

public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        if(nums.length < 3) return 0;
        Arrays.sort(nums);
        int num = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) continue;
            int l = i+1, r = nums.length-1;
            while(l < r) {
                if(nums[l] + nums[r] > nums[i]) {
                    num += l-r;
                    r--;
                } else {
                    l++;
                }
            }
        }
        return num;
    }
}
