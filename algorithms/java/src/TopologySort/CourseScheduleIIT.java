package TopologySort;

import java.util.*;

public class CourseScheduleIIT {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        List<HashSet<Integer>> adjs = new ArrayList<>(numCourses);
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adjs.add(new HashSet<Integer>());
        }
        for (int[] edge : prerequisites) {
            int start = edge[0];
            int end = edge[1];
            inDegree[end]++;
            adjs.get(start).add(end);
        }

        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        int j = 0;
        while (!q.isEmpty()) {
            int i = q.poll();
            result[j++] = i;
            for (Integer nb : adjs.get(i)) {
                inDegree[nb]--;
                if (inDegree[nb] == 0) {
                    q.offer(nb);
                }
            }
        }
        if (j < numCourses - 1) return null;
        return result;
    }
}
