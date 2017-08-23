package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(Interval[] intervals) {
        int count = 0;
        if(intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                if(o1.end != o2.end) {
                    return o1.end - o2.end;
                } else {
                    return o1.start - o2.start;
                }
            }
        });
        int end = -1;
        for(Interval v : intervals) {
            if(v.start >= end) {
                count++;
                end = v.end;
            }
        }
        return intervals.length - count;
    }
}
