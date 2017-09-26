package NumberOfIslands;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import UnionFind.NumberOfIslandsII;
import org.junit.Test;

public class NumberOfIslandsIITest {
    @Test
    public void test() {
        NumberOfIslandsII sol = new NumberOfIslandsII();
        List<Integer> result = sol.numIslands2(3, 3, new int[][]{{0,0},{0,1},{1,2},{2,1}});
        assertEquals(new ArrayList<Integer>(){
            {
                add(1);
                add(1);
                add(2);
                add(3);
            }
        }, result);

        result = sol.numIslands2(3, 3, new int[][]{{0,1},{1,2},{2,1},{1,0},{0,2},{0,0},{1,1}});
        assertEquals(new ArrayList<Integer>(){
            {
                add(1);
                add(2);
                add(3);
                add(4);
                add(3);
                add(2);
                add(1);
            }
        }, result);

    }
}
