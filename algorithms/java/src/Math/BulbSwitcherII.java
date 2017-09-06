package Math;

public class BulbSwitcherII {
    public int flipLights(int n, int m) {
        if (n == 0 || m == 0) return 1;
        if (n == 1) return 2;
        // n >= 2, m >= 1
        if (n == 2) return m == 1 ? 3 : 4;
        // n > 2
        if (m == 1) return 4;
        // n > 2 m >= 2
        return m == 2 ? 7 : 8;
    }
}
