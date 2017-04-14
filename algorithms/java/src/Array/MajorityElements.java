package Array;

import java.util.ArrayList;
import java.util.List;
// Given an integer array of size n, find all elements that appear **more than** [n/3] times.
// The algorithm should run in linear time and in O(1) space
// NOTE: there is at most two numbers
public class MajorityElements {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        int m1 = 0;
        int m2 = 0;
        int c1 = 0;
        int c2 = 0;

        for (int num : nums) {
            // These below judges can be more concise.
            if (c1 == 0 && m2 != num) { // c1 == 0, then m1 is invalid, it's no need to compare m1 with num
                m1 = num;
            } else if (c2 == 0 && m1 != num) {
                m2 = num;
            }

            if (m1 == num) { //
                c1++;
            } else if (m2 == num) {
                c2++;
            } else {
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        for (int num: nums) {
            if (num == m1) {
                c1++;
            } else if (num == m2) {
                c2++;
            }
        }
        if (c1 > nums.length/3) {
            result.add(m1);
        }
        if (c2 > nums.length/3) {
            result.add(m2);
        }
        return result;
    }
}
