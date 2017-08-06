package Greedy;

public class CandyT {
    public int candy(int[] ratings) {
        int[] c = new int[ratings.length];
        int count = 0;
        for (int i = 0; i < ratings.length; i++) {
            if (i == 0) {
                c[i] = 1;
                continue;
            }

            if (ratings[i] > ratings[i - 1]) {
                c[i] = c[i - 1] + 1;
            } else {
                c[i] = 1;
            }
        }

        count += c[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                c[i] = Math.max(c[i], c[i + 1] + 1);
            }
            count += c[i];
        }
        return count;
    }
}
