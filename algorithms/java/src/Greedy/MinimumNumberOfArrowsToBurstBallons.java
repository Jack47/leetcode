package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBallons {
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0) return 0;
        Arrays.sort(points, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                return o1[1]-o2[1];
            }
        });
        int end = points[0][1];
        int count = 1;
        for(int[] point : points) {
            if(point[0] > end) {
                count++;
                end = point[1];
            }
        }
        return count;
    }
}
