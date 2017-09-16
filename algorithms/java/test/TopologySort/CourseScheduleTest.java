package TopologySort;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CourseScheduleTest {
    @Test
    public void test() {
        CourseScheduleT c = new CourseScheduleT();
        boolean can = c.canFinish(2, new int[][]{{0,1}});
        assertEquals(true, can);
    }
}
