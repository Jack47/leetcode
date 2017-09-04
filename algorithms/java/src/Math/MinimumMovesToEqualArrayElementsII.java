package Math;

public class MinimumMovesToEqualArrayElementsII {
    int partition(int[] nums, int s, int e) {
        int pivot = nums[s];
        while (s < e) {
            while (s < e && nums[e] >= pivot) {
                e--;
            }
            if (s < e) {
                nums[s] = nums[e]; // e is free
                s++;
            }
            while (s < e && nums[s] < pivot) {
                s++;
            }
            if (s < e) {
                nums[e] = nums[s]; // s is free
                e--;
            }
        }
        nums[s] = pivot;
        return s;
    }

    int findMedian(int[] nums) {
        int left = 0, right = nums.length - 1;
        int k = nums.length / 2;
        while (true) {
            int i = partition(nums, left, right);
            if (i == k) return nums[i];
            else if (i < k) { // must in right part
                left = i + 1;
            } else { // must in left part
                right = i - 1;
            }
        }
    }

    public int minMoves2(int[] nums) {
        if (nums.length == 0) return 0;

        int median = findMedian(nums);
        int moves = 0;
        for (int num : nums) {
            moves += Math.abs(num - median);
        }
        return moves;
    }
}
