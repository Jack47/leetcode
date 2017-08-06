package Greedy;

public class CreateMaximumNumber {
    int[] getMaxKelements(int[] nums, int k) {
        if (k == 0) return new int[0];
        if (k > nums.length) return null;
        if (k == nums.length) return nums;

        int[] result = new int[k];
        int top = -1;
        for (int i = 0; i < nums.length; i++) {
            // use larger number if we have enough nums
            while (top >= 0 && nums.length - i >= (k - top) && result[top] < nums[i]) {
                top--;
            }
            // store current nums if has capacity;
            if (top < k - 1) {
                result[++top] = nums[i];
            }
        }

        return result;
    }

    int[] merge(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        int k = 0;
        int i = 0, j = 0;
        while (i < nums1.length || j < nums2.length) {
            if (j >= nums2.length || i < nums1.length && isGreater(nums1, i, nums2, j)) {
                result[k++] = nums1[i++];
            } else {
                result[k++] = nums2[j++];
            }
        }
        return result;
    }

    boolean isGreater(int[] nums1, int s1, int[] nums2, int s2) {
        if (nums1 == null) return false;
        if(nums2 == null) return true;
        while (s1 < nums1.length && s2 < nums2.length) {
            if (nums1[s1] == nums2[s2]) {
                s1++;
                s2++;
            } else if (nums1[s1] > nums2[s2]) {
                return true;
            } else {
                return false;
            }
        }
        return s1 < nums1.length ? true : false; // equal or end
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] max = null;
        for (int i = 0; i <= k; i++) {
            int[] n1 = getMaxKelements(nums1, i);
            int[] n2 = getMaxKelements(nums2, k - i);
            if (n1 == null || n2 == null) {
                continue;
            }
            int[] result = merge(n1, n2);
            if (isGreater(result, 0, max, 0)) {
                max = result;
            }
        }
        return max;
    }
}
