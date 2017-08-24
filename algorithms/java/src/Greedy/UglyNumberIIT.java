package Greedy;

public class UglyNumberIIT {
    public int nthUglyNumber(int n) {
        if (n <= 6) return n;
        int[] ugly = new int[n];
        ugly[0] = 1;
        ugly[1] = 2;
        ugly[2] = 3;
        ugly[3] = 4;
        ugly[4] = 5;

        int i = 2; // ugly[2]*2 = 3*2 = 6
        int j = 1; // ugly[1]*3 = 2*3 = 6
        int k = 1; // ugly[1]*5 = 2*5 = 10
        int ii = ugly[i]*2;
        int jj = ugly[j]*3;
        int kk = ugly[k]*5;

        int count = 5;
        int min = 0;
        while (count < n) {
            min = Math.min(ii, Math.min(jj, kk));
            if (min == ii) {
                i++;
                ii = ugly[i]*2;
            }
            if (min == jj) {
                j++;
                jj = ugly[j]*3;
            }
            if (min == kk) {
                k++;
                kk = ugly[k]*5;
            }
            ugly[count++] = min;
        }
        return ugly[n - 1];
    }
}
