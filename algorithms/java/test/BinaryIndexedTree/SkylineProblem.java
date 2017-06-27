package BinaryIndexedTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SkylineProblem {
    public List<int[]> getSkyline(int[][] buildings) {
        int[][] sortedPoints = new int[buildings.length * 2][3];
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < buildings.length; i++) {
            sortedPoints[i * 2][0] = buildings[i][0]; // left
            sortedPoints[i * 2][1] = 1; // indicate it's left
            sortedPoints[i * 2][2] = i; // index in original array

            sortedPoints[i * 2 + 1][0] = buildings[i][1]; // right
            sortedPoints[i * 2 + 1][1] = 2; // indicate it's right
            sortedPoints[i * 2 + 1][2] = i; // index in original array
        }
        Arrays.sort(sortedPoints, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1]; // left first
            }
            return a[0] - b[0];
        });
        HashMap<Integer, Integer> map = new HashMap<>();
        int nums = 0;
        for (int[] point : sortedPoints) {
            map.put(point[0], ++nums); // same value will share one larger index
        }
        int[] BiTree = new int[nums];
        int prevHeight = 0;
        for (int[] point : sortedPoints) {
            int l, r, h;
            if (point[1] == 1) { // left
                l = buildings[point[2]][0];
                r = buildings[point[2]][1];
                h = buildings[point[2]][2];
                add(BiTree, map.get(r), h); // add right
            } else { // right
                l = point[0]; // left or right, both needs to find height
            }
            int height = search(BiTree, map.get(l)+1); // important: find the max height, use index + 1 to avoid it's the right; for left, this will effect.
            if(height != prevHeight) {
                int len = result.size();
                if(result.get(len-1)[0] == l) {
                   int th = Math.max(result.get(len-1)[1], height);
                   result.get(len-1)[1] = th;
                } else {
                    result.add(new int[]{l, height});
                }
                prevHeight = height;

            }
        }
        return result;
    }

    void add(int[] BiTree, int index, int height) {
        // go left
        while (index > 0) {
            BiTree[index] = Math.max(height, BiTree[index]);
            index -= index & (-index);
        }
    }

    int search(int[] BiTree, int index) {
        int max = Integer.MIN_VALUE;
        while (index < BiTree.length) {
            max = Math.max(BiTree[index], max);
            index += index & (-index);
        }
        return max;
    }
}
