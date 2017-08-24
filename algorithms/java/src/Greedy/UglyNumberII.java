package Greedy;

public class UglyNumberII {
    public int nthUglyNumber(int n) {
        if (n <= 0) return 0;
        int[] ugly = new int[n];
        ugly[0] = 1;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        int f2 = 2;
        int f3 = 3;
        int f5 = 5;
        int min = 1;
        for (int i = 1; i <= n-1; i++) {
            min = Math.min(f2, Math.min(f3, f5));
            if (min % 2 == 0) {
                i2++;
                f2 = ugly[i2] * 2;
            }
            if (min == f3) {
                i3++;
                f3 = ugly[i3] * 3;
            }
            if (min == f5) {
                i5++;
                f5 = ugly[i5] * 5;
            }
            ugly[i] = min;
        }
        return ugly[n - 1];
    }
}
