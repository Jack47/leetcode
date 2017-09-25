package Coding;

import java.util.TreeSet;

public class NextClosestTime {
    String result;
    StringBuilder sb;
    TreeSet<Character> set;
    String originalTime;
    int originalMinutes;
    int minDeltaMinutes;

    void dfs(int i) {
        if (i == 5) {
            String r = sb.toString();
            int minutes = parseMinutes(r);
            int delta = minutes - originalMinutes;
            if (delta == 0) delta = 24 * 60; // skip original time
            if (delta < 0) {
                delta = minutes + (24 * 60 - originalMinutes);
            }
            if (delta < minDeltaMinutes) {
                result = r;
                minDeltaMinutes = delta;
            }
            return;
        }
        if (i == 2) {
            sb.setCharAt(i, ':');
            dfs(i + 1);
            return;
        }
        for (Character ch : set) {
            sb.setCharAt(i, ch);
            if (i == 0 && ch <= '2' ||
                    i == 1 && Integer.parseInt(sb.substring(0, 2)) <= 23 ||
                    i == 3 && ch <= '5' ||
                    i == 4 && Integer.parseInt(sb.substring(3, 4)) <= 59) {
                dfs(i + 1);
            }
        }
    }

    int parseMinutes(String time) {
        return Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3, 5));
    }

    public String nextClosestTime(String time) {
        sb = new StringBuilder();
        this.originalTime = time;
        sb.setLength(5);

        set = new TreeSet<>();
        for (char ch : time.toCharArray()) {
            if (ch != ':') {
                set.add(ch);
            }
        }
        originalMinutes = parseMinutes(originalTime);
        minDeltaMinutes = Integer.MAX_VALUE;
        dfs(0);
        return result;
    }
}
