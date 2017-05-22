package Graph;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CourseScheduleTest {
    @Test
    public void test() {
        CourseSchedule s = new CourseSchedule();
        boolean real = s.canFinish(2, new int[][]{{1, 0}});
        assertEquals(true, real);

        real = s.canFinish(2, new int[][]{{1, 0}});
        assertEquals(true, real);

        real = s.canFinish(2, new int[][]{{1, 0}, {0, 1}});
        assertEquals(false, real);
    }
}
