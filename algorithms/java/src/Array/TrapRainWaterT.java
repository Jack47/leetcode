package Array;

public class TrapRainWaterT {
    public int trap(int[] height) {
        if(height.length == 0) return 0;
        int left = 0, right = height.length-1;
        int leftMax = height[0];
        int rightMax = height[height.length-1];
        int water = 0;
        while(left < right) {
            if(height[left] < height[right]) {
                if(leftMax < height[left]) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if(rightMax < height[right]) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        return water;
    }
}
