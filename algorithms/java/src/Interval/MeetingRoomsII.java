package Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class MeetingRoomsII {
    class BiTree {
        int[] biTree;

        public BiTree(int size) {
            biTree = new int[size + 1];
        }

        void add(int i) {
            while (i > 0) {
                biTree[i]++;
                i -= i & (-i);
            }
        }

        int search(int i) {
            int ret = 0;
            while (i <= biTree.length) {
                ret += biTree[i];
                i += i & (-i);
            }
            return ret;
        }
    }

    public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length == 0) return 0;

        int[][] sortedPoint = new int[intervals.length * 2][3];
        for (int i = 0; i < intervals.length; i++) {
            sortedPoint[2 * i] = new int[]{intervals[i].start, 1, i};
            sortedPoint[2 * i + 1] = new int[]{intervals[i].end, 2, i};
        }
        Arrays.sort(sortedPoint, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        int num = 0;
        for (int i = 0; i < sortedPoint.length; i++) {
            indexMap.put(sortedPoint[i][0], ++num);
        }
        BiTree biTree = new BiTree(num);

        int maxRooms = 0;
        for (int i = 0; i < sortedPoint.length; i++) {
            int[] point = sortedPoint[i];
            int l, r;
            if (point[1] == 1) {
                l = point[0];
                r = intervals[point[2]].end;
                biTree.add(indexMap.get(r));
            } else {
                l = point[0];
            }
            int rooms = biTree.search(indexMap.get(l)+1);
            if(rooms < maxRooms) {
                maxRooms = rooms;
            }
        }
        return maxRooms;
    }
}
