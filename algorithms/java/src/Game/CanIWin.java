package Game;

import java.util.HashMap;

public class CanIWin {
    int max;
    boolean[] visited;
    HashMap<Integer, Boolean> cache;
    int convert(boolean[] visited) {
        // we can also use Arrays.toString(visited);
        int n = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                n |= 1 << i;
            }
        }
        return n;
    }

    boolean canWin(int desiredTotal) {
        // you don't have choice to choose
        // opposite has win
        if (desiredTotal <= 0) return false;
        int key = convert(visited);
        if(cache.containsKey(key)) {
            return cache.get(key);
        }
        // choose from all these unused integer
        for (int i = 1; i <= max; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (!canWin(desiredTotal - i)) {
                    visited[i] = false;
                    cache.put(key, true);
                    return true;
                }
                visited[i] = false;
            }
        }
        cache.put(key, false);
        return false;
    }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        max = maxChoosableInteger;
        int sum = (1 + max) * max / 2;
        if (sum < desiredTotal) {
            return false;
        }
        if (desiredTotal == 0) return true;
        cache = new HashMap<>();
        visited = new boolean[max + 1];

        return canWin(desiredTotal);
    }
}
