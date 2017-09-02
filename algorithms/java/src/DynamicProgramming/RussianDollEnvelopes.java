package DynamicProgramming;

import java.util.Arrays;

public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) return 0;
        // (w, h), sort by w ascending, h descending
        Arrays.sort(envelopes, (a, b) -> (a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]));
        int max = 0;
        int[] count = new int[envelopes.length];

        // [2,3], [5,4], [6,3], [6,7], [7,4]
        for (int i = 0; i < envelopes.length; i++) {
            // if height
            int index = Arrays.binarySearch(count, 0, max, envelopes[i][1]);
            if (index < 0) {
                index = -index - 1;
            }
            // it must be the current lowest element that len is
            count[index] = envelopes[i][1];
            // (index+1)
            if (index + 1 > max) {
                max = index+1;
            }
        }
        return max;
    }
}
