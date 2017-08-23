package Math;

public class GasStationT {
    public int canCompleteCircuit(int[] gases, int[] costs) {
        if (gases == null || gases.length == 0) return -1;
        int start = 0;
        int curCost = 0, totalCost = 0, curGas = 0, totalGas = 0;
        for (int i = 0; i < gases.length; i++) {
            totalGas += gases[i];
            curGas += gases[i];
            totalCost += costs[i];
            curCost += costs[i];
            if (curCost > curGas) {
                start = i + 1;
                curCost = 0;
                curGas = 0;
            }
        }
        return totalCost <= totalGas ? start : -1;
    }
}
