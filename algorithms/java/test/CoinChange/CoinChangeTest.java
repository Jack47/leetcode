package CoinChange;

import static org.junit.Assert.assertEquals;

import DynamicProgramming.CoinChange;
import org.junit.Test;

public class CoinChangeTest {
    @Test
    public void test() {
        CoinChange coinChange = new CoinChange();
        int num = coinChange.coinChange(new int[]{1, 2}, 1);
        assertEquals(1, num);

        num = coinChange.coinChange(new int[]{1, 5, 2}, 11);
        assertEquals(3, num);

        num = coinChange.coinChange(new int[]{1, 2}, 11);
        assertEquals(6, num);

        num = coinChange.coinChange(new int[]{1, 5, 6}, 11);
        assertEquals(2, num);

        num = coinChange.coinChange(new int[]{186, 419, 83, 408}, 6249);
        assertEquals(20, num);
    }
}
