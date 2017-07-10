package DynamicProgramming;

public class PaintHouseII {
    int[] minExceptSelf(int[] costs) {
        int[] result = new int[costs.length];
        result[0] = costs[0];
        for (int i = 1; i < costs.length; i++) {
            result[i] = Math.min(result[i - 1], costs[i]);
        }
        int[] t = new int[costs.length];
        t[costs.length - 1] = costs[costs.length - 1];
        result[costs.length - 1] = result[costs.length - 2];
        for (int i = costs.length - 2; i >= 0; i--) {
            t[i] = Math.min(t[i + 1], costs[i]);
            result[i] = Math.min(i > 0 ? result[i - 1] : Integer.MAX_VALUE, t[i + 1]);
        }
        return result;
    }

    public int minCostII(int[][] costs) {
        if (costs.length == 0 || costs[0].length == 0) return 0;

        int[] finalCost = new int[costs[0].length];
        // init first final cost
        for (int j = 0; j < finalCost.length; j++) {
            finalCost[j] = costs[0][j];
        }

        // compute all final cost
        for (int i = 1; i < costs.length; i++) {
            int[] result = minExceptSelf(finalCost);
            for (int j = 0; j < costs[0].length; j++) {
                finalCost[j] = costs[i][j] + result[j];
            }
        }
        // get the min final cost
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < finalCost.length; j++) {
            min = Math.min(min, finalCost[j]);
        }
        return min;
    }
}
