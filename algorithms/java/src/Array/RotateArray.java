package Array;

public class RotateArray {
    void rightShift(int[] nums) {
        if (nums == null || nums.length == 1) return;
        int t = nums[nums.length - 1];
        for (int i = nums.length - 1; i >= 1; i--) {
            nums[i] = nums[i - 1];
        }
        nums[0] = t;
    }

    public void rotateTLE(int[] nums, int k) {
        k = k % nums.length;
        while (k > 0) {
            k--;
            rightShift(nums);
        }
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (nums == null || nums.length == 1 || k == 0) return;

        int count = 0;
        int i = 0;
        while (count < nums.length) { // loop at most twice
            int t = nums[i];
            int curPos = i;
            int prevPos = curPos - k >= 0 ? curPos - k : nums.length - k + curPos;
            while (prevPos != i) {
                nums[curPos] = nums[prevPos];
                curPos = prevPos;
                prevPos = curPos - k >= 0 ? curPos - k : nums.length - k + curPos;
                count++;
            }
            count++;
            nums[curPos] = t;
            i++;
        }
    }
}
