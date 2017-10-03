package Greedy;

import java.util.Arrays;
import java.util.LinkedList;

public class QueueReconstructionByHeightT {
    public int[][] reconstructQueue(int[][] people) {
        // sort by height(max) and kth(min)
        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        LinkedList<int[]> result = new LinkedList<>();
        for (int[] p : people) {
            result.add(p[1], p);
        }
        int[][] ret = new int[0][0];
        result.toArray(ret);
        return ret;
    }
}
