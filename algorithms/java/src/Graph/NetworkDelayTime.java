package Graph;

import java.util.Arrays;
import java.util.PriorityQueue;

// Dijstra algorithm to calculate the shortest
// path from source node to other nodes
public class NetworkDelayTime {
    class Edge {
        int weight;
        int j;
        public Edge(int j, int w) {
            this.j = j;
            weight = w;
        }
    }
    public int networkDelayTime(int[][] times, int N, int K) {
        int[] shortestPath = new int[N+1]; // shortest path start from K to i
        Arrays.fill(shortestPath, Integer.MAX_VALUE);
        shortestPath[K] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b)->(a.weight-b.weight));
        int[][] matrix = new int[N+1][N+1];
        for(int[] m : matrix) {
            Arrays.fill(m, -1);
        }
        for(int[] eg : times) {
            matrix[eg[0]][eg[1]] = eg[2];
        }
        pq.add(new Edge(K, 0));
        while(!pq.isEmpty()) {
            Edge e = pq.poll();
            for(int i = 1; i < matrix[e.j].length; i++) { // add unvisited reachable adjacent neighbors
                // reachable            &&  unvisited(visited node has found the shortest path)
                if(matrix[e.j][i] > -1 && shortestPath[i]  > shortestPath[e.j]+ matrix[e.j][i]) {
                    shortestPath[i] = shortestPath[e.j] + matrix[e.j][i];
                    pq.add(new Edge(i, shortestPath[i]));
                }
            }
        }
        int ret = 0;
        for(int i = 1; i < shortestPath.length; i++) {
            // some node unreachable
            if(shortestPath[i] == Integer.MAX_VALUE) {
                return -1;
            }
            ret = Math.max(ret, shortestPath[i]);
        }
        return ret;
    }
}
