package Combination;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MenuCombinationSumTest {
    @Test
    public void test() {
        MenuCombinationSum mcs = new MenuCombinationSum();
        List<Double> prices = new ArrayList<>();
        prices.add(11.0);
        prices.add(12.0);
        prices.add(13.0);
        prices.add(14.0);
        prices.add(10.0);

        List<List<Double>> real1 = mcs.getCombosDP(prices, 100.0);
        List<List<Double>> real2 = mcs.getCombos(prices, 100.0);
        assertEquals(real1, real2);
    }
}
