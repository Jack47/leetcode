package Combination;

import java.util.*;

public class SubSetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        List<List<Integer>> currentResult = null;
        if (nums == null || nums.length == 0) return resultList;

        Arrays.sort(nums);
        resultList.add(new ArrayList<Integer>());

        for (int i = 0; i < nums.length; i++) { // every number has two possibility : in or not
            // in subset
            currentResult = new ArrayList<List<Integer>>();
            for (int k = 0; k < resultList.size(); k++) {
                List<Integer> subset = resultList.get(k);
                if (subset.size() == 0 || subset.get(subset.size() - 1) != nums[i]) {
                    currentResult.add(new ArrayList<Integer>(resultList.get(k)));
                }
                List<Integer> tmpList = new ArrayList<Integer>(resultList.get(k));
                tmpList.add(new Integer(nums[i]));
                currentResult.add(tmpList);
            }
            resultList = currentResult;
        }

        return resultList;
    }
}
