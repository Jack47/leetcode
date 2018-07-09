package Combination;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIITest {
    @Test
    public void test () {
        CombinationSumII cs = new CombinationSumII();
        List<List<Integer>> real = cs.combinationSum2(new int[]{2, 1, 1}, 2);
        List<List<Integer>> expected = new ArrayList<>();

        real = cs.combinationSum2(new int[]{10, 1,2,7,6,1,5}, 8);
        expected = new ArrayList<>();
    }
}
