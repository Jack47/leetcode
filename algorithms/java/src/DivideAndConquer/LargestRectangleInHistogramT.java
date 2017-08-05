package DivideAndConquer;

import java.util.Stack;

public class LargestRectangleInHistogramT {
    int[] heights;

    int divide(int s, int e) {
        if (s == e) return heights[s];
        int m = s + (e - s) / 2;
        int leftMax = divide(s, m);
        int rightMax = divide(m + 1, e);
        int max = Math.max(leftMax, rightMax);
        int left = m, right = m + 1;
        int small = Math.min(heights[right], heights[left]);
        int len = 2;
        max = Math.max(max, len * small);
        while (left - 1 >= s || right + 1 <= e) {
            if (right + 1 > e || left - 1 >= s && heights[left - 1] > heights[right + 1]) {
                left--;
                small = Math.min(small, heights[left]);
            } else {
                right++;
                small = Math.min(heights[right], small);
            }
            len = right - left + 1;
            max = Math.max(max, len * small);
        }
        return max;
    }

    public int largestRectangleAreaDivideAndConquer(int[] heights) {
        if (heights.length == 0) return 0;
        this.heights = heights;
        return divide(0, heights.length - 1);
    }

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        int i = 0;
        int max = 0;
        while (i < heights.length && !s.isEmpty()) {
            if (heights[i] >= heights[s.peek()]) {
                s.push(i);
                i++;
            } else {
                while (s.size() > 1 && heights[i] < heights[s.peek()]) {
                    s.pop();
                    int k = s.peek();
                    max = Math.max((i - k - 1) * heights[k], max);
                }
                s.push(i);
                i++;
            }
        }
        while (s.size() > 1) {
            s.pop();
            int k = s.peek();
            max = Math.max((i - k - 1) * heights[k], max);
        }
        return max;
    }
}
