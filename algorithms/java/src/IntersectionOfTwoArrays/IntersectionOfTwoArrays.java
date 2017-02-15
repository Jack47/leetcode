package IntersectionOfTwoArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
// https://leetcode.com/problems/intersection-of-two-arrays/
// Given two arrays, write a function to compute their intersection.
public class IntersectionOfTwoArrays {
    public int[] intersectionBackedByTwoPointers(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> ret = new ArrayList<Integer>();

        int i = 0;
        int j = 0;
        int nextI = 0;
        int nextJ = 0;

        while( i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                ret.add(nums1[i]);
                nextI = i +1;
                while(nextI < nums1.length && (nums1[i] == nums1[nextI])) {
                    nextI++;
                }
                i = nextI;
                nextJ = j+1;
                while(nextJ < nums2.length && (nums2[j] == nums2[nextJ])) {
                    nextJ++;
                }
                j = nextJ;
            }
            while(i < nums1.length && j < nums2.length && nums1[i] < nums2[j]) {
                i++;
            }
            while(i < nums1.length && j < nums2.length && nums1[i] > nums2[j]) {
                j++;
            }
        }
        int []retA = new int[ret.size()];
        for (int x = 0; x < ret.size(); x++) {
            retA[x] = ret.get(x);
        }
        return retA;
    }
    public int[] intersectionBackedByHashTable(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            if (!set.contains(nums1[i])) {
                set.add(nums1[i]);
            }
        }
        Arrays.sort(nums2);
        for (int j = 0; j < nums2.length; j++) {
            if (j + 1 < nums2.length && nums2[j] == nums2[j+1]) {
                continue;
            }
            if (set.contains(nums2[j])) {
                result.add(nums2[j]);
            }
        }

        int []retA = new int[result.size()];
        for (int x = 0; x < result.size(); x++) {
            retA[x] = result.get(x);
        }
        return retA;
    }
}
