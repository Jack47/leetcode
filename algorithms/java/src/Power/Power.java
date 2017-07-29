package Power;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/powx-n/
 * Implement pow(x, n);
 */
public class Power {
    double[] powTable;

    public Power() {
        // powTable[i] = x^2^i
        powTable = new double[32];
    }
    public double myPow(double x, int n) {
        if(n < 0) return 1/(x * myPow(x, -(n+1)));
        if (n==1) {
            return x;
        }
        else if (n == 0) {
            return 1;
        }
        if(n % 2 == 0) {
            double r = myPow(x, n/2);
            return r*r;
        } else {
            return x*myPow(x, n-1);
        }
    }
    public double myPowTable(double x, int n) {
        if (x == 1) {
            return x;
        }
        if (n == 1) {
            return x;
        }
        if (n == 0) {
            return 1;
        }
        if (n < 0) {

            return 1 / (x * myPowTable(x, -(n + 1)));
        }
        if (Math.abs(x) < 2 * Double.MIN_VALUE) {
            return 0;
        }
        if ((n & (n - 1)) == 0) {
            int nthBit = getBitCount(n) - 1;
            if (powTable[nthBit] == 0) {
                double num = myPowTable(x, n / 2);
                powTable[nthBit] = num * num;
            }
            return powTable[nthBit];
        } else {
            List<Integer> binaryList = toBinaryList(n);
            double pow = 1;
            int weight = 1;
            for (int j = binaryList.size() - 1; j >= 0; j--) {
                Integer bit = binaryList.get(j);
                if (bit != 0) {
                    pow = pow * myPowTable(x, bit * weight);
                }
                weight = weight << 1;
            }
            return pow;
        }

    }

    protected static int getBitCount(int n) {
        assert (n >= 0);
        assert (n & (n - 1)) == 0;
        int bitCounter = 0;
        while (n > 0) {
            bitCounter++;
            n = n >> 1;
        }
        return bitCounter;
    }

    protected static List<Integer> toBinaryList(int n) {
        List<Integer> result = new LinkedList<Integer>();
        while (n > 0) {
            result.add(0, n % 2);
            n = n / 2;
        }
        return result;
    }
}
