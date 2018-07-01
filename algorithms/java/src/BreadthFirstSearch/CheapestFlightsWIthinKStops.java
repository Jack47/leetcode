package BreadthFirstSearch;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightsWIthinKStops {
    int[][] getAdjacentMatrix(int[][] flights, int n) {
        int[][] matrix = new int[n][n]; // 0 is the flag
        for(int i = 0; i < flights.length;i++) {
            int src = flights[i][0];
            int dst = flights[i][1];
            int price = flights[i][2];
            matrix[src][dst] = price;
        }
        return matrix;
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        int[][] matrix = getAdjacentMatrix(flights, n);
        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[src] = 0; // costs of start point is zero
        K++; // it's inter-midate step, we want edges
        q.add(src);
        int curLevelNumber = q.size();
        while(K > 0 && !q.isEmpty()) {
           int newSrc = q.poll();
           if(visited[newSrc]) {
               continue;
           }
           visited[newSrc] = true;
           // one step on all neighbors
           for(int i = 0; i < n; i++) {
               if (i != newSrc && matrix[newSrc][i] > 0) {// flight exists
                   q.add(i);
                   if(costs[newSrc] + matrix[newSrc][i] < costs[i]) { // cheaper route
                       costs[i] = costs[newSrc] + matrix[newSrc][i];
                   }
               }
           }
           curLevelNumber--;
           if (curLevelNumber == 0) {
               curLevelNumber = q.size();
               K--;
           }
        }
        return costs[dst] < Integer.MAX_VALUE ? costs[dst]: -1;
    }
}
