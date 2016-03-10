package Duplicate;

import java.util.TreeSet;

/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i
 * and j in the array such that nums[i] = nums[j]
 *
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        for (int num : nums) {
            boolean inserted = treeSet.add(num);
            if (!inserted) return true;
        }
        return false;
    }

    public boolean containsDuplicate1(int[] nums) {
        if (nums == null || nums.length == 1) return false;
        int capacity = (int) (nums.length * 0.75);
        capacity = capacity < 10 ? 10 : capacity;
        MyHashSet hashSet = new MyHashSet(capacity);
        for (int num : nums) {
            if (hashSet.add(num) == false) return true;
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        MyBitMap myBitMap = new MyBitMap(nums.length);
        for (int num : nums) {
            if (myBitMap.test(num)) {
                return true;
            } else {
                myBitMap.set(num);
            }
        }
        return false;
    }
}
