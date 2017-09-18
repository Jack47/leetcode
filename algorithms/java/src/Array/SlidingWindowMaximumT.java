package Array;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximumT {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0) return new int[0];
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> q = new ArrayDeque<>(k);

        for (int i = 0; i < nums.length; i++) {
            if (q.size() > 0 && q.peekFirst() < i - k + 1) {
                q.pollFirst();
            }
            while (q.size() > 0 && nums[i] > nums[q.peekLast()]) {
                q.pollLast();
            }
            q.offerLast(i);
            if (i >= k - 1) {
                result[i - k + 1] = nums[q.peekFirst()];
            }
        }
        return result;
    }
}
