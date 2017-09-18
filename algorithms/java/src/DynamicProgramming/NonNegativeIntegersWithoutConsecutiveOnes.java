package DynamicProgramming;

public class NonNegativeIntegersWithoutConsecutiveOnes {
    public int findIntegers(int num) {
        String binary = Integer.toBinaryString(num);
        int n = binary.length();
        int[] a0 = new int[n];
        int[] b1 = new int[n];
        a0[n - 1] = b1[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            a0[i] = a0[i + 1] + b1[i + 1];
            b1[i] = a0[i + 1];
        }
        int result = a0[0] + b1[0];
        for (int i = 1; i < n; i++) {
            if (binary.charAt(i) == '1' && binary.charAt(i - 1) == '1') {
                break;
            } else if (binary.charAt(i) == '0' && binary.charAt(i - 1) == '0') {
                result -= b1[i];
            }
        }
        return result;
    }
}
