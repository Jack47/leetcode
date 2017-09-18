package Greedy;

import java.util.List;
import java.util.PriorityQueue;

public class SmallestRange {
    class Element {
        int val, idx, row;

        Element(int val, int row, int idx) {
            this.val = val;
            this.row = row;
            this.idx = idx;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));
        int max = Integer.MIN_VALUE;
        int min = 0;
        int smallestRange = Integer.MAX_VALUE;
        int smallestRangeMin = 0;
        int smallestRangeMax = 0;

        for (int i = 0; i < nums.size(); i++) {
            List<Integer> num = nums.get(i);
            pq.offer(new Element(num.get(0), i, 0));
            max = Math.max(max, num.get(0));
        }
        while (pq.size() >= nums.size()) {
            Element minElem = pq.poll();
            min = minElem.val;
            if (max - min < smallestRange) {
                smallestRange = max - min;
                smallestRangeMin = min;
                smallestRangeMax = max;
            }
            if (minElem.idx < nums.get(minElem.row).size() - 1) {
                minElem.idx++;
                minElem.val = nums.get(minElem.row).get(minElem.idx);
                pq.offer(minElem);
                max = Math.max(max, minElem.val);
            }
        }
        int[] result = new int[2];
        result[0] = smallestRangeMin;
        result[1] = smallestRangeMax;
        return result;
    }
}
