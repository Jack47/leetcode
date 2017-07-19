package Array;

public class TrapRainWater {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right) {
            // container water on shorter height side
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left]; // increasing, can't contain water
                } else {
                    result += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) { // increasing, can't contain water
                    rightMax = height[right];
                } else {
                    result += rightMax - height[right];
                }
                right--;
            }
        }
        return result;
    }
}
