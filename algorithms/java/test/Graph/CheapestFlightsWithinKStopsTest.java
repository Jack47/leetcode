package Graph;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheapestFlightsWithinKStopsTest {
    @Test
    public void test() {
        CheapestFlightsWIthinKStops cf = new CheapestFlightsWIthinKStops();
        int[][] flights = new int[][]{{0,1,5}, {1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}};
        int real = cf.findCheapestPrice(5, flights, 0, 2, 2);
        assertEquals(7, real);
    }
}
