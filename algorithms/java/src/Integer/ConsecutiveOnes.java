package Integer;

import java.util.HashMap;

public class ConsecutiveOnes {
    boolean hasConsecutiveOnes(int n) {
        while ( n != 0) {
            int i = Integer.highestOneBit(n);
            if ((n & (1 << i - 1)) > 0) {
                return true;
            }
            n = n ^ (1 << i);
        }
        return false;
    }
    HashMap<Integer, Boolean> m = new HashMap<Integer, Boolean>();
    public int findIntegers(int num) {
        int count = 0;

        for (int i = 0; i <= num; i ++) {
            m.get(i);
        }
        return count;
    }
}
