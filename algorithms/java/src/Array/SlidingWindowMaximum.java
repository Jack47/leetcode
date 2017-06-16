package Array;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length < k || k < 1) {
            return null;
        }

        Deque<Integer> q = new ArrayDeque<Integer>();
        int resultLen = nums.length-k +1;
        int[] result = new int[resultLen];
        int i = 0;
        int j = 0;
        // q containers index
        while(i < nums.length) {
            // remove numbers out of range k
            if (!q.isEmpty()&&q.peek() < i -k+1) {
                q.poll();
            }

            // remove smaller numbers in k range as they are useless
            while(!q.isEmpty()&&nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            // q containers index
            q.offerLast(i);
            // q.first means the max
            if(i >= k-1) {
                result[j++] = nums[q.peek()];
            }
            i++;
        }
        return result;
    }
}
