package SortColors;

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the
 * same color are adjacent, with the colors
 * in the order red, white and blue
 */
public class SortColors {
    public void sortColors(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int num = nums[i];
                    nums[i] = nums[j];
                    nums[j] = num;
                }
            }
        }
    }

    public void sortColors1(int[] nums) {
        quickSort(0, nums.length - 1, nums);
    }

    public void sortColors2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int dest = 2;
        while (dest > 0 && (left < right)) {
            while (left < right) {
                while (left < right && nums[left] != dest) {
                    left++;
                }
                while (left < right && nums[right] == dest) {
                    right--;
                }
                if (left < right) {
                    int num = nums[left];
                    nums[left] = nums[right];
                    nums[right] = num;
                }
            }
            if (nums[right] == dest) right--;
            dest--;
            left = 0;
        }

    }

    public void sortColors3(int[] nums) {
        int number0 = 0;
        int number1 = 0;
        for (int num : nums) {
            if (num == 0) {
                number0++;
            } else if (num == 1) {
                number1++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < number0)
                nums[i] = 0;
            else if (i < number0 + number1) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }

    public void quickSort(int left, int right, int[] nums) {
        if (left >= right) return;
        int pivot = nums[left];
        int index = left;
        int l = left + 1;
        int r = right;
        while (l <= r) {
            while (l <= r && nums[l] < pivot) {
                l++;
            }
            while (l <= r && nums[r] >= pivot) {
                r--;
            }
            if (l < r) {
                nums[index] = nums[r];
                nums[r] = nums[l];
                index = l;
                l++;
            }
        }
        nums[index] = nums[l - 1];
        nums[l - 1] = pivot;
        quickSort(left, l - 2, nums);
        quickSort(l, right, nums);
    }
}
