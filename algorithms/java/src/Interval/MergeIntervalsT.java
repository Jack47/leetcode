package Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervalsT {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null) return null;
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start != o2.start) {
                    return o1.start - o2.start;
                } else {
                    return o1.end - o2.end;
                }
            }
        });

        List<Interval> newList = new ArrayList<>(intervals.size());
        boolean begin = false;
        int s=0, e=0;
        for(Interval a : intervals) {
            if(begin) {
                if(a.start > e) {
                    begin = false;
                    newList.add(new Interval(s, e));
                } else {
                    e = Math.max(e, a.end);
                }
            }
            if(!begin) {
                begin = true;
                s = a.start;
                e = a.end;
            }
        }
        if(begin) {
            newList.add(new Interval(s, e));
        }
        return newList;
    }
}
