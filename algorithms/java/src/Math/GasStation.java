package Math;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 0) return 0;
        // cost[i]: travel from i to i+1;
        int start = 0;
        int gasSum = 0;
        int costSum = 0;
        int tank = 0;
        for (int i = 0; i <= gas.length - 1; i++) { // current positon i, want to go to i+1;
            costSum += cost[i];
            gasSum += gas[i]; //
            tank += gas[i] - cost[i]; //fist cost
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        return gasSum >= costSum ? start : -1;
    }
}
