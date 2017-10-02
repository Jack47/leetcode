package BinaryIndexedTree;

import java.util.HashSet;
import java.util.Set;

public class KemptySlots {
    int[] biTree;
    int n;

    void add(int i) {
        while (i <= n) {
            biTree[i] += 1;
            i += i & (-i);
        }
    }

    int search(int i) {
        int count = 0;
        while (i >= 1) {
            count += biTree[i];
            i -= i & (-i);
        }
        return count;
    }

    public int kEmptySlots(int[] flowers, int k) {
        n = flowers.length;
        biTree = new int[n + 1];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < flowers.length; i++) {
            int pos = flowers[i];
            int cur = search(pos);
            if (set.contains(pos-k-1) && search(pos - k - 1) == cur ||
                    set.contains(pos+k+1) && search(pos + k + 1) == cur+1) {
                return i+1;
            }
            set.add(pos);
            add(pos);
        }
        return -1;
    }
}
