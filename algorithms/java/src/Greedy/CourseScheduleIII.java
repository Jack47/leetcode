package Greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CourseScheduleIII {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> (a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]));
        // find the largest duration course
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (a - b));
        int end = 0;
        for (int[] course : courses) {
            int duration = course[0];
            int endDay = course[1];
            pq.offer(duration);
            end += duration;
            if (end + duration > endDay) {
                end -= pq.poll();
            }
        }
        return pq.size();
    }
}
