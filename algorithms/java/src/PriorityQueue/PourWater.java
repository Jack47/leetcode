package PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PourWater {
    public int[] pourWater(int[] heights, int V, int K) {
        int dst = K;
        int i = K-1;
        while(V > 0) {
            // find left pos to fall
            while (i >= 0 && heights[i] <= heights[i+1]) { // decreasing, so can flow left physically
                if (heights[i] < heights[dst]) {
                    dst = i;
                }
                i--;
            }
            if(dst < K) { // left pos exist
                V--;
                heights[dst]++;
            } else { // find right post to fall
                i = K+1;
                dst = K;
               while(i < heights.length && heights[i] <= heights[i-1]) {
                   if(heights[i] < heights[dst]) {
                       dst = i;
                   }
                   i++;
               }
               if (dst > K) {
                   heights[dst]++;
               } else {
                   heights[K]++; // can't find left or right pos to fall
               }
                V--;
            }
        }
        return heights;
    }
}
