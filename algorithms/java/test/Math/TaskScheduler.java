package Math;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char ch : tasks) {
            freq[ch - 'A']++;
        }
        int[] validIndex = new int[26];
        int count = 0;
        int pos = 0;
        if (n <= 1 || tasks.length == 1) return tasks.length;
        while (count < tasks.length) {
            int cur = findMaxFreqValidChar(pos, freq, validIndex);
            if (cur >= 0) {
                validIndex[cur] = pos + n + 1;
                freq[cur]--;
                count++;
            } // else put idle interval
            pos++;
        }

        return pos + 1;
    }

    int findMaxFreqValidChar(int curPos, int[] freq, int[] validIndex) {
        int max = Integer.MIN_VALUE;
        int result = -1;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0 && validIndex[i] <= curPos && max < freq[i]) {
                max = freq[i];
                result = i;
            }
        }
        return result;
    }
}
