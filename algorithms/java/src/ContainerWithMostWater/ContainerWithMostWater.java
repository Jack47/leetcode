package ContainerWithMostWater;
// https://leetcode.com/problems/container-with-most-water/#/description
// Given a non-negative intergers a1, a2, ..., an, where each represents a point at
// (i, ai). n vertical lines are drawn such that the two endpoints of line i at (i, ai)
// and (i, 0). Find two lines, which together with x-axis forms a container, such that
// the container containers the most water.
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int low = 0;
        int high = height.length - 1;
        int max = 0;
        while (low < high) {
            int s = (high - low) * Math.min(height[low], height[high]);
            if (s > max) {
                max = s;
            }
            if (height[low] <= height[high]) {
                low++;
            } else {
                high--;
            }
        }
        return max;
    }
}
