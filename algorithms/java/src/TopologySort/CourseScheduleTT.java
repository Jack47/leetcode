package TopologySort;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class CourseScheduleTT {
    // use topology sort to find whether there is a way
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        Set<Integer>[] adjs = new HashSet[n];
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            adjs[i] = new HashSet<>();
        }
        for (int[] pair : prerequisites) {
            int s = pair[1];
            int e = pair[0];
            adjs[s].add(e);
            inDegree[e]++;
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }
        int count = 0;
        while (!q.isEmpty()) {
            int k = q.poll();
            count++;
            Set<Integer> nbs = adjs[k];
            for (Integer nb : nbs) {
                inDegree[nb]--;
                if (inDegree[nb] == 0) {
                    q.offer(nb);
                }
            }
        }
        return count == n;
    }
}
