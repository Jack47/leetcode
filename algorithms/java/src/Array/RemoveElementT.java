package Array;

public class RemoveElementT {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int i = 0, j = nums.length - 1;
        while (i < j) {
            while (i < j && nums[j] == val) {
                j--;
            }
            while (i < j && nums[i] != val) {
                i++;
            }
            if (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                i++;
                j--;
            }
        }
        return nums[i] == val ? i : i + 1;
    }
}
