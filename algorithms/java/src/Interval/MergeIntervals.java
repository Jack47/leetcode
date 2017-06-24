package Interval;

import java.util.*;

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class MergeIntervals {
    Comparator<Interval> intervalComparator = new Comparator<Interval>() {
        @Override
        public int compare(Interval o1, Interval o2) {
            if (o1.start < o2.start) return -1;
            else if (o1.start == o2.start) return 0;
            else return 1;
        }
    };

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) return intervals;

        List<Interval> result = new ArrayList<Interval>();
        Collections.sort(intervals, intervalComparator);

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            Interval n = intervals.get(i);
            if (n.start <= end) {
                end = Math.max(n.end, end);
            } else {
                result.add(new Interval(start, end));
                start = n.start;
                end = n.end;
            }
        }
        result.add(new Interval(start, end));
        return result;
    }
}
