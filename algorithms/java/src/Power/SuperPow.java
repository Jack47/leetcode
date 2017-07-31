package Power;

public class SuperPow {
    final static int m = 1337;

    int powWithMod(int a, int b) {
        if (b == 0 || a == 1) return 1;
        if (b == 1) return a % m; // be cautious here
        a = a % m;

        int result = 1;
        for (int i = 1; i <= b; i++) {
            result *= a;
            result = result % m; // import to avoid overflow
        }
        return result;
    }

    public int superPow(int a, int[] b) {
        int result = 1;

        for (int n : b) {
            result = (powWithMod(result, 10) * powWithMod(a, n)) % m;
        }
        return result;
    }
}
