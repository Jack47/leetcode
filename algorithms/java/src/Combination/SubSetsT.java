package Combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetsT {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>()); // empty set is subsets of all
        for(int i = 0; i < nums.length;i++) {
            List<List<Integer>> newResults = new ArrayList<>();
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
        return results;
    }
}
