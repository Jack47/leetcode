package StringRelated;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FindKthSmallestPairDistance {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            // if(i > 0 && nums[i] == nums[i-1]) {
            // continue;
            // }
            for (int j = i; j < nums.length; j++) {
                // if(j > i && nums[j] == nums[j-1]) {
                //   continue;
                // }
                pq.offer(nums[j] - nums[i]);
            }
        }
        int num = 0;
        while (k > 0) {
            num = pq.poll();
            k--;
        }
        return num;
    }
}
