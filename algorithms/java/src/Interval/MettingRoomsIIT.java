package Interval;

import java.util.*;

public class MettingRoomsIIT {
    public int minMeetingRoomsT(Interval[] intervals) {
        Arrays.sort(intervals, (a, b)->(a.start-b.start));
        int maxRoom = 0;

        // iterate elements and store the current overlapped
        // intervals in list
        List<Interval> intersections = new LinkedList<>();
        for(Interval cur : intervals) {
            // overlapped intervals are store in ascending order(.start)
            Iterator<Interval> iter = intersections.iterator();
            while(iter.hasNext()) {
                Interval prev = iter.next();
                if(prev.end < cur.start) {// useless now
                    iter.remove();
                }
            }
            intersections.add(cur);
            maxRoom = Math.max(maxRoom, intersections.size());
        }
        return maxRoom;
    }

    public static int Start = 1;
    public static int End = 2;
    class Event {
        int time;
        int type;
        public Event(int time, int type) {
            this.time = time;
            this.type = type;
        }
    }
    public int minMeetingRooms(Interval[] intervals) {
        Queue<Event> events = new PriorityQueue<>((a,b) -> (a.type==b.type?a.time-b.time:a.type-b.type));
        for(Interval itv : intervals) {
            events.add(new Event(itv.start, Start));
            events.add(new Event(itv.end, End));
        }
        int maxRoom = 0;
        int rooms = 0;
        while(!events.isEmpty()){
            Event e = events.poll();
            if(e.type == Start) {
                rooms++;
                maxRoom = Math.max(rooms, maxRoom);
            } else {
                rooms--;
            }
        }
        return maxRoom;
    }
}
