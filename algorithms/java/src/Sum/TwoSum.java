package Sum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TwoSum {
    /**
     * Initialize your data structure here.
     */
    HashMap<Integer, Integer> map;
    List<Integer> nums;

    public TwoSum() {
        map = new HashMap<Integer, Integer>();
        nums = new ArrayList<Integer>();
    }

    /**
     * Add the number to an internal data structure..
     */
    public void add(int number) {
        nums.add(number);
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    /**
     * Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        for (int num : nums) {
            if (map.get(value - num) != null) {
                if (num != value - num) return true;
                if (num == value - num && map.get(value - num) > 1) return true;
            }
        }
        return false;
    }
}
