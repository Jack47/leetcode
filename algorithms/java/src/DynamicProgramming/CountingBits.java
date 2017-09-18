package DynamicProgramming;

public class CountingBits {
    public int[] countBits1(int num) {
        int[] result = new int[num + 1];
        result[0] = 0;
        for (int i = 0; i <= num; i++) {
            result[i] = result[i / 2] + i % 2;
        }
        return result;
    }

    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        result[0] = 0;
        for (int i = 0; i <= num; i++) {
            result[i] = result[i & (i - 1)] + 1;
        }
        return result;
    }
}
