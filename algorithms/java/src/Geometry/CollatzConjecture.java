package Geometry;

import java.util.TreeMap;

public class CollatzConjecture {
    TreeMap<Integer, Integer> caches;
    int findSteps(int n) {
        if(caches.containsKey(n)) {
            return caches.get(n);
        }
        int steps = 0;
        if(n%2 > 0) { // odd
            steps = findSteps(3*n+1);
        }
        steps = findSteps(n/2);
        caches.put(n, steps+1);
        return 1+steps;
    }
    public int findLongestSteps(int num) {
        caches = new TreeMap<>();
        int max = 0;
        for(int i = 1; i <= num ; i++) {
          max = Math.max(max, findSteps(i));
        }
        return max;
    }
}
