package Prime;

import java.util.Arrays;

public class CountPrime {
    boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        if (n == 0) return 0;

        int count = 0; // 1 is not prime
        for (int i = 2; i * i <= n; i++) {
            if (!isPrime(i)) continue;
            for (int j = i*i; j < n; j+=i) {
                isPrime[j * i] = false;
            }
        }
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }
}
