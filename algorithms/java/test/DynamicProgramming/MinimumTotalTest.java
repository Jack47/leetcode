package DynamicProgramming;

import static junit.framework.TestCase.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MinimumTotalTest {
    @Test
    public void test() {
        TriangleMinimumTotal s = new TriangleMinimumTotal();
        List<List<Integer>> triangles = new ArrayList<>();
        triangles.add(new ArrayList<Integer>() {
            {
                add(-1);
            }
        });
        triangles.add(new ArrayList<Integer>() {
            {
                add(3);
                add(2);
            }
        });

        triangles.add(new ArrayList<Integer>() {

            {
                add(-3);
                add(1);
                add(-1);
            }
        });

        int result = s.minimumTotal(triangles);
        assertEquals(-1, result);
    }
}
