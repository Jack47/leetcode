package Math;

public class SuperWashingMachines {
    public int findMinMoves(int[] machines) {
        int result = 0;
        int n = machines.length;
        int[] sum = new int[n+1];
        for(int i = 1; i <= n; i++) {
            sum[i] = sum[i-1]+machines[i-1];
        }
        if(sum[n]%n != 0) return -1;
        int avg = sum[n]/n;
        for(int i = 1; i <= n; i++) {
            int l = avg*(i-1) - sum[i-1];
            int r = avg*(n-i) - (sum[n] - sum[i]);
            if(l > 0 && r > 0) { // move to left and right, two opposite direction
                int max = Math.abs(l) + Math.abs(r);
                result = Math.max(result, max);
            } else { // l > 0, r > 0; l > 0, r < 0; l < 0, r > 0;
                int max = Math.max(Math.abs(l), Math.abs(r));
                result = Math.max(result, max);
            }
        }
        return result;
    }
}
