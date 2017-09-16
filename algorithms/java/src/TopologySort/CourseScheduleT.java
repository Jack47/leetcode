package TopologySort;

import java.util.*;

public class CourseScheduleT {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<HashSet<Integer>> adjs = new ArrayList<>(numCourses);
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjs.add(new HashSet<>());
        }
        for (int[] edge : prerequisites) {
            int start = edge[0];
            int end = edge[1];
            HashSet<Integer> nbs = adjs.get(start);
            nbs.add(end);
            inDegree[end]++;
        }

        Queue<Integer> leaves = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                leaves.offer(i);
            }
        }
        int visitedVertex = 0;
        while (!leaves.isEmpty()) {
            int i = leaves.poll();
            visitedVertex++;
            HashSet<Integer> nbs = adjs.get(i);
            for (Integer nb : nbs) {
                inDegree[nb]--;
                if (inDegree[nb] == 0) {
                    leaves.offer(nb);
                }
            }
        }
        return visitedVertex == numCourses;
    }
}
