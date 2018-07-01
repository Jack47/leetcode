package PriorityQueue;

public class PourWater {
    public int[] pourWater(int[] heights, int V, int K) {
        while(V > 0) {
            int i = K-1;
            int minIndex = K;
            while (i >= 0 && heights[i] <= heights[i+1]) { // decreasing, so can flow left physically
                if(heights[i] < heights[minIndex]) {
                    minIndex = i;
                }
                i--;
            }
            if(minIndex < K) { // left pos exist
                V--;
                heights[minIndex]++;
            } else { // find right post to fall
                i = K+1;
                minIndex = K;
                while(i < heights.length && heights[i] <= heights[i-1]) {
                    if(heights[i] < heights[minIndex]) {
                        minIndex = i;
                    }
                    i++;
                }
                if (minIndex > K) {
                    heights[minIndex]++;
                } else {
                    heights[K]++; // can't find left or right pos to fall
                }
                V--;
            }
        }
        return heights;
    }
}
