package QuickSort;

import java.util.PriorityQueue;

public class FindKthLargestT {
    public int findKthLargest(int[] nums, int k) {
        // k largest elements so far
        PriorityQueue<Integer> pq = new PriorityQueue<>(k+1);
        for(int num : nums) {
            pq.add(num);
            if(pq.size() > k) { // emit the minimum
                pq.poll();
            }
        }
        // so the min-heap stores the current kth largest element
        return pq.poll();
  }
}
