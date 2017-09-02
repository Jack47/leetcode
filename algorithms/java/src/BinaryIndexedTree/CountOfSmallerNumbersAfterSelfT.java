package BinaryIndexedTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountOfSmallerNumbersAfterSelfT {
    void update(int[]biTree, int i) {
        i++;
        while(i < biTree.length) {
            biTree[i]+=1;
            i+=i&(-i);
        }
    }
    int search(int[]biTree, int i) { // count for <=i
        i++;
        int count = 0;
        while(i > 0) {
            count += biTree[i];
            i -= i&(-i);
        }
        return count;
    }
    int binarySearchLE(int[] nums, int num) {
        int l = 0, r = nums.length;
        while(l <= r) {
            int m = l + (r-l)/2;
            if(nums[m] >= num) {
                r = m-1;
            } else { // nums[m] < num
                l = m+1;
            }
        }
        return l >= 0 && l <= nums.length && nums[l] == num ? l : r;
    }
    public List<Integer> countSmaller(int[] nums) {
        if(nums.length == 0) return Collections.emptyList();
        int[] biTree = new int[nums.length+1];
        int[] cp_nums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(cp_nums);
        List<Integer> result = new ArrayList<>();
        for(int j = nums.length-1; j >= 0; j--) {
            int count = search(biTree, binarySearchLE(cp_nums, nums[j]-1)); // smaller number
            result.add(0, count);
            update(biTree, binarySearchLE(cp_nums, nums[j]));
        }
        return result;
    }
}
