package BinaryIndexedTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        int[] BiTree = new int[nums.length + 1];
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);
        LinkedList<Integer> result = new LinkedList<Integer>();

        for (int i = nums.length-1; i >= 0; i--) { // start from right, so we can do follow:
            int searchIndex = 1 + binarySearch(sortedNums, nums[i]-1); // search number of smaller nums on the right
            result.add(0, search(BiTree, searchIndex));
            int updateIndex = 1 + binarySearch(sortedNums, nums[i]);
            update(BiTree, updateIndex);
        }

        return result;
    }
    int search(int[] BiTree, int i) {
        int result = 0;
        while(i > 0) {
            result += BiTree[i];
            i -= i&(-i);
        }
        return result;
    }
    void update(int[] BiTree, int i) {
        while(i < BiTree.length) {
            BiTree[i]++;
            i += i&(-i);
        }
    }
    int binarySearch(int[] nums, int val) {
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
        return nums[left] == val ? left : right;
    }
}
