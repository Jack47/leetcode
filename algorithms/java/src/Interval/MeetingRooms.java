package Interval;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals.length <= 1) return true;
        Arrays.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start != o2.start) {
                    return o1.start - o2.start;
                } else {
                    return o1.end - o2.end;
                }
            }
        });

        for(int i = 1; i < intervals.length; i++) {
            Interval pre = intervals[i-1];
            Interval cur = intervals[i];

            if(pre.start == cur.start || pre.start < cur.start && pre.end > cur.start) {
                return false;
            }
        }
        return true;
    }
}
