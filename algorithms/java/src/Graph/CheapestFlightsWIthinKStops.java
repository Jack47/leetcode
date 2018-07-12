package Graph;

import java.util.PriorityQueue;

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
        // [price][dst_vertix][steps]
        PriorityQueue<Integer[]> q = new PriorityQueue<>((a, b)->(a[0]-b[0]));
        int[][] matrix = getAdjacentMatrix(flights, n);
        K++; // it's inter-mediate edges, we want stop
        q.add(new Integer[]{0, src, 0});
        int price = Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            Integer[] e = q.poll();
            int s = e[1];
            System.out.printf("choose: {%d,%d,%d}\n", e[0], e[1], e[2]);
            if(s == dst) {
                price = Math.min(price, e[0]);
                System.out.printf("%d\n",price);
            }

            if(e[2] == K) {
                continue;
            }
            System.out.printf("add:\n");
            for(int i = 0; i < n; i++) { // find all neighbors
                if (matrix[s][i] > 0) {
                    q.add(new Integer[]{e[0]+matrix[s][i], i, e[2]+1});
                    System.out.printf("\t{%d,%d,%d}", e[0]+matrix[s][i], i, e[2]+1);
                }
            }
            System.out.printf("\n");
        }
        return price;
    }
}
