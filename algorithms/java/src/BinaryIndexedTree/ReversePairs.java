package BinaryIndexedTree;

import java.util.Arrays;

public class ReversePairs {
    int[] nums;
    int[] BiTree;

    public int reversePairs(int[] nums) {
        this.nums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(this.nums);
        BiTree = new int[nums.length + 1];
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int index = 1 + binarySearch(this.nums, (long)(nums[i] * 2) + 1); // nums[j] > 2*nums[i]
            result += search(BiTree, index); // how many nodes are there ?
            index = 1 + binarySearch(this.nums, nums[i]);
            insert(BiTree, index);
        }
        return result;
    }

    void insert(int[] BiTree, int i) {
        while (i > 0) {
            BiTree[i] += 1;
            i -= i & (-i);
        }
    }

    int search(int[] BiTree, int i) {
        int ret = 0;
        while (i < BiTree.length) {
            ret += BiTree[i];
            i += i & (-i);
        }
        return ret;
    }

    int binarySearch(int[] nums, long val) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= val) {
                right = mid - 1;
            } else if (nums[mid] < val) {
                left = mid + 1;
            }
        }
        return left;
    }
}
