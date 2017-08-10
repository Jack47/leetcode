package Array;

public class MoveZerosT {
    public void moveZeroes(int[] nums) {
        if (nums.length == 0) return;

        int i = 0, j = 0;
        while (j < nums.length) {
            while (j < nums.length && nums[j] == 0) {
                j++;
            }
            if (j == nums.length) break;
            if (i != j) {
                nums[i] = nums[j];
            }
            i++;
            j++;
        }
        while (i < nums.length) {
            nums[i] = 0;
            i++;
        }
    }
}
