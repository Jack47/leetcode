package Interval;

import java.util.Arrays;

public class MeetingRoomsT {
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, (a, b)->(a.start - b.start));
        int preEnd = -1;
        for(Interval it : intervals) {
            if (it.start < preEnd) {
                return false;
            }
            preEnd = it.end;
        }
        return true;
    }
}
