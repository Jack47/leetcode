package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructionByHeight {
    // insert to ith position [0..ith]
    void insert(int[][] queue, int i, int[] pair) {
        int j = 0;
        int count = 0;
        while(j < queue.length) {
            if(queue[j] == null) {
                if(count == i) {
                    queue[j] = pair;
                    return;
                }
                count++;
            }

            j++;
        }
    }
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o2[0] - o1[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        List<int[]> result = new LinkedList<>();
        for(int[] pair:people) {
            result.add(pair[1], pair);
        }
        int[][] res = new int[people.length][2];
        return result.toArray(res);
    }
}
