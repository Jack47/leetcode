package Greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CourseScheduleIIIT {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> (a[1] - b[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        int end = 0;
        for (int[] course : courses) {
            int t = course[0];
            int d = course[1];
            end += t;
            pq.offer(t);
            if (end > d) {
                int max = pq.poll();
                end -= max;
            }
        }
        return pq.size();
    }
}
