package IntersectionOfTwoArrays;

import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> ret = new ArrayList<Integer>();

        if (!isSorted(nums1)) {
            Arrays.sort(nums1);
        }
        if (!isSorted(nums2)) {
            Arrays.sort(nums2);
        }
        int i = 0;
        int j = 0;
        while(i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                ret.add(nums1[i]);
                i++;
                j++;
            } else if(nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] result = new int[ret.size()];
        for (int x = 0; x < ret.size(); x++) {
            result[x] = ret.get(x);
        }
        return result;
    }
    private boolean isSorted(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i+1]) {
                return false;
            }
        }
        return true;
    }
}
