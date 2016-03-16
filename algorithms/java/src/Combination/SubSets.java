package Combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/
 * Given a set of distinct integers, nums, return all possible subsets.
 * NOTE:
 * Elements in a subset must be in non-descending order
 * The solution set must not contain duplicate subsets.
 */
public class SubSets {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return resultList;
        long combinations = (1 << nums.length) - 1;
        List<Integer> result = new ArrayList<Integer>();
        for (int permutation = 0; permutation <= combinations; permutation++) {
            result.clear();
            for (int i = 0; i < nums.length; i++) {
                if ((permutation & (1 << i)) != 0) {
                    result.add(nums[i]);
                }
            }
            resultList.add(new ArrayList<Integer>(result));
        }

        return resultList;
    }
}
