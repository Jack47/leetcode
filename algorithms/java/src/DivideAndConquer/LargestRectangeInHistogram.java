package DivideAndConquer;

import java.util.Stack;

public class LargestRectangeInHistogram {
    int largest(int[] h, int s, int e) {
        if (s == e) return h[s];
        int m = s + (e - s) / 2;

        int left = largest(h, s, m);
        int right = largest(h, m + 1, e);

        int max = Math.max(left, right);
        int min = Math.min(h[m], h[m + 1]);
        int width = 2;

        int i = m, j = m + 1;
        while (i >= s && j <= e) {
            min = Math.min(min, Math.min(h[j], h[i]));
            max = Math.max(max, width * min);
            width++;
            if (i == s) {
                j++;
            } else if (j == e) {
                i--;
            } else {
                if (h[i - 1] >= h[j + 1]) {
                    i--;
                } else {
                    j++;
                }
            }
        }
        return max;
    }

    public int largestRectangleAreaDivideAndConquer(int[] heights) {
        if (heights.length == 0) return 0;
        return largest(heights, 0, heights.length - 1);
    }

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        if (heights.length == 1) return heights[0];
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        int max = 0;
        int i;
        for (i = 0; i < heights.length; i++) {
            if (s.size() == 1 || heights[i] >= heights[s.peek()]) {
                s.push(i);
            } else {
                while(s.size() > 1 && heights[i] < heights[s.peek()]) {
                    int h = heights[s.pop()];
                    int w = i - s.peek() - 1;
                    max = Math.max(h * w, max);
                }
                s.push(i);
            }
        }
        while (s.size() > 1) {
            int h = heights[s.pop()];
            int w = i - s.peek() - 1;
            max = Math.max(h * w, max);
        }
        return max;
    }
}
