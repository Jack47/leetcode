package Graph;

import java.util.LinkedList;
import java.util.Queue;
// https://leetcode.com/problems/course-schedule/#/description
// the input prerequisites is a graph represented by *a list of edges*, not adjacency matrix.
// Topology sort, it's kind of BFS
public class CourseSchedule {
    // use Topology sort
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        int matrix[][] = new int[numCourses][numCourses];
        int in_degree[] = new int[numCourses];
        // [1, 0], 1<-0

        // assign adjacent matrix
        // compute in-degree
        for (int[] rows : prerequisites) {
            int end = rows[0];
            int start = rows[1];
            matrix[start][end] = 1;
            in_degree[end]++;
        }
        // init
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < numCourses; i++) {
            if (in_degree[i] == 0) {
                queue.add(i);
            }
        }
        int visitedNode = 0;
        while(!queue.isEmpty()) { // O(E)
            int i = queue.poll();
            visitedNode++;
            for (int j = 0; j < numCourses; j++) {
                if(matrix[i][j] != 0) {
                    in_degree[j]--;
                    if (in_degree[j] == 0) {
                        queue.add(j);
                    }
                }
            }
        }
        if (visitedNode < numCourses) {
            return false;
        }
        return true;
    }
    // Use DFS to detect cycle
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] graph = makeGraph(numCourses, prerequisites);

        // global visited array
        boolean[] visited = new boolean[numCourses];
        // current visited path array
        boolean[] curPathVisited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) { // Graph may has many start point
                if(dfs_has_cycle(i, numCourses, graph, visited, curPathVisited)){
                    return false;
                }
            }
        }
        return true;
    }
    boolean dfs_has_cycle(int n, int numCourses, int [][] graph, boolean[] visited, boolean[] curPathVisited) {
        if (visited[n]) { // skip visited node.
            return false;
        }
        visited[n] = true;
        curPathVisited[n] = true;
        for(int j = 0; j < numCourses; j++) { // dfs traverse the adjacent nodes
            if (graph[n][j] != 0) {
                // has cycle
                if (curPathVisited[j] || dfs_has_cycle(j, numCourses, graph, visited, curPathVisited)) {
                    return true;
                }
            }
        }
        curPathVisited[n] = false;
        return false;
    }
    int [][] makeGraph(int numCourses, int[][] prerequisites) {
        int[][] graph = new int[numCourses][numCourses];
        for(int[] pre : prerequisites) {
            int start = pre[1];
            int end = pre[0];
            graph[start][end] = 1;
        }
        return graph;
    }
}
