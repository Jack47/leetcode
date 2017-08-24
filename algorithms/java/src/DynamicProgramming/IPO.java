package DynamicProgramming;

import java.util.PriorityQueue;

public class IPO {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        // queue ascending by capital
        PriorityQueue<int[]> projects = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        for (int i = 0; i < Profits.length; i++) {
            projects.offer(new int[]{Profits[i], Capital[i]});
        }

        int count = 0;
        // big value priority queue
        PriorityQueue<Integer> candidates = new PriorityQueue<>((a, b) -> (b - a));
        while (projects.size() > 0 || candidates.size() > 0) {
            while (projects.size() > 0 && projects.peek()[1] <= W) { // we can afford it
                int[] p = projects.poll();
                candidates.offer(p[0] - p[1]); // only store pure profit
            }
            if(candidates.size() == 0) return W;
            W += candidates.poll();
            count++;
            if (count == k) break;
        }
        return W;
    }
}
