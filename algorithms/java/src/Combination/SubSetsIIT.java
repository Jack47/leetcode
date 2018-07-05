package Combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SubSetsIIT {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        // We can rely on HashSet to help reduce duplicate set
        // Because the List<Integer> is already ordered.
        HashSet<List<Integer>> results = new HashSet<>();
        results.add(new ArrayList<>()); // empty set is subsets of all
        for(int i = 0; i < nums.length;i++) {
            HashSet<List<Integer>> newResults = new HashSet<>();
            for(List<Integer> result : results) {
                // don't include nums[i]
                newResults.add(new ArrayList<>(result));
                // include nums[i]
                List<Integer> t = new ArrayList<>(result);
                t.add(nums[i]);
                newResults.add(t);
            }
            results = newResults;
        }
        List<List<Integer>> ret = new ArrayList<>(results);
        return ret;
    }

     public List<List<Integer>> subsetsWithDupT(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>()); // empty set is subsets of all
        for(int i = 0; i < nums.length;i++) {
            List<List<Integer>> newResults = new ArrayList<>();
            for(List<Integer> result : results) {
                // don't include nums[i]
                if (!(i > 0 && nums[i] == nums[i-1])) {
                    newResults.add(new ArrayList<>(result));
                }
                // include nums[i]
                List<Integer> t = new ArrayList<>(result);
                t.add(nums[i]);
                newResults.add(t);
            }
            results = newResults;
        }
        List<List<Integer>> ret = new ArrayList<>(results);
        return ret;
    }
}
