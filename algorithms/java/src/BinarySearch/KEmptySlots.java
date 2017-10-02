package BinarySearch;

import java.util.TreeSet;

public class KEmptySlots {
    public int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> s = new TreeSet<>();
        int day = 0;
        for (int pos : flowers) {
            Integer next = s.ceiling(pos); // least greater or equal
            Integer pre = s.floor(pos); // least small or equal
            if (pre != null && pos - pre == k + 1 ||
                    next != null && next - pos == k + 1) {
                return day + 1;
            }
            s.add(pos);
            day++;
        }

        return -1;
    }
}
