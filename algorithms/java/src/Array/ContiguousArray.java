package Array;

import java.util.HashMap;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i] == '0' ? -1 : 1;
            if(sum == 0) {
                max = i;
            } else if(map.containsKey(sum)) {
                max = Math.max(max, i - map.get(sum));
            }
            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return max;
    }
}
