package IntersectionOfTwoArrays;

import java.util.*;

public class IntersectionOfTwoArraysII_I {
    public int[] intersectI(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        if (nums2.length < nums1.length) {
            int[] t = nums2;
            nums2 = nums1;
            nums1 = t;
        }
        for(int i = 0; i <nums1.length; i++) {
           int count = map.getOrDefault(nums1[i], 0);
           map.put(nums1[i], count+1);
        }
        int j = 0;
        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i < nums2.length; i++) {
            int count = map.getOrDefault(nums2[i], 0);
           if(count > 0) {
                ret.add(nums2[i]);
                map.put(nums2[i], count-1);
           }
        }
        int[] result = new int[ret.size()];
        for(int i = 0; i < result.length; i++) {
            result[i] = ret.get(i);
        }
        return result;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // let nums1[0] <= nums2[0]
        if (nums1[0] > nums2[0]) {
            int[] t = nums1;
            nums1 = nums2;
            nums2 = t;
        }
        int index = Arrays.binarySearch(nums1, nums2[0]);
        int i = index >= 0 ? index : -index - 1;
        int j = 0;
        List<Integer> ret = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                ret.add(nums1[i]);
                i++;
                j++;
            } else if(nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        int[] result = new int[ret.size()];
        for(int k = 0; k < ret.size(); k++) {
            result[k] = ret.get(k);
        }
        return result;
    }
}
